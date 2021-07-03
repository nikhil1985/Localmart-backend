package com.localmart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.localmart.controller.response.StoreResponse;
import com.localmart.entities.ClientInfo;
import com.localmart.entities.db.sequence.service.SequenceGeneratorService;
import com.localmart.entities.mapper.CategoryMapper;
import com.localmart.entities.mapper.ClientInfoMapper;
import com.localmart.entities.mapper.ItemListMapper;
import com.localmart.entities.mapper.UserProfileMapper;
import com.localmart.file.service.FileStorageService;
import com.localmart.image.ImageCompression;
import com.localmart.image.impl.ImageMultipart;
import com.localmart.model.Categories;
import com.localmart.model.Category;
import com.localmart.model.ItemList;
import com.localmart.model.Payload;
import com.localmart.model.UserProfile;
import com.localmart.repositories.CategoryRepository;
import com.localmart.repositories.PayloadRepository;
import com.localmart.repositories.UserProfileRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/webapi")
public class PostApiController {

	@Autowired
	UserProfileRepository userProfileRepository;

	@Autowired
	SequenceGeneratorService seqGeneratorService;

	@Autowired
	PayloadRepository payloadRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	FileStorageService fileStorageService;

	@Autowired
	StoreResponse responseBack;

	private final ImageCompression imageCompression;

	@Autowired
	public PostApiController(ImageCompression imageCompression) {
		this.imageCompression = imageCompression;
	}

	@PostMapping(path = "/userRegister", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> saveCustomer(@RequestBody UserProfile userProfileModel) {

		try {

			com.localmart.entities.UserProfile userProfileEntity = UserProfileMapper.INSTANCE
					.toUserProfileEntity(userProfileModel);

			userProfileEntity
					.setId(seqGeneratorService.generateSequence(com.localmart.entities.UserProfile.SEQUENCE_NAME));

			userProfileRepository.save(userProfileEntity);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(path = "/savePayload", consumes = "application/json", produces = "application/json")
	public ResponseEntity<StoreResponse> savePayload(@RequestBody Payload payload) {

		com.localmart.entities.Payload existingPayloadEntity = payloadRepository
				.findPayloadByEmailId(payload.getClientInfo().getEmail());

		List<com.localmart.entities.ItemList> itemListEntity = new ArrayList<>();
		ItemListMapper itemListMapper = ItemListMapper.INSTANCE;
		ClientInfoMapper clientInfoMapper = ClientInfoMapper.INSTANCE;

		ClientInfo clientInfoEntity = clientInfoMapper.toItemListEntity(payload.getClientInfo());

		for (ItemList itemList : payload.getItemList()) {
			itemListEntity.add(itemListMapper.toItemListEntity(itemList));
		}

		com.localmart.entities.Payload payloadEntity = new com.localmart.entities.Payload();
		if (null != existingPayloadEntity) {
			payloadEntity.setId(existingPayloadEntity.getId());
		} else {
			payloadEntity.setId(seqGeneratorService.generateSequence(com.localmart.entities.Payload.SEQUENCE_NAME));

		}
		payloadEntity.setClientInfo(clientInfoEntity);
		payloadEntity.setItemList(itemListEntity);

		payloadRepository.save(payloadEntity);
		responseBack.setResponceCode(HttpStatus.OK.value());
		responseBack.setResponseText("Store detail save successfully");
		responseBack.setStoreName(payload.getClientInfo().getStoreName());

		return new ResponseEntity<>(responseBack, HttpStatus.OK);
	}

	@PostMapping("/saveImageCategory")
	public ResponseEntity<StoreResponse> saveUser(@RequestParam("images") MultipartFile[] multipartImgFiles,
			@RequestParam("categories") String categories) throws IOException {
		String pathToStoreImages = new ClassPathResource("images/").getPath();
		Arrays.asList(multipartImgFiles).stream().forEach(file -> {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			System.out.println(fileName);
			imageCompression.compress(new ImageMultipart(file), fileName.substring(0, fileName.indexOf('.')),
					pathToStoreImages);

		});

		List<com.localmart.entities.Category> categoryEntityList = new ArrayList<com.localmart.entities.Category>();
		CategoryMapper categorymapper = CategoryMapper.INSTANCE;

		Categories categoriesModel = new ObjectMapper().readValue(categories, Categories.class);
		for (Category category : categoriesModel.getCategories()) {
			category.setImage(category.getImage());
			categoryEntityList.add(categorymapper.toCategoryEntity(category));
		}
		categoryRepository.deleteAll();
		categoryRepository.saveAll(categoryEntityList);
		responseBack.setResponceCode(HttpStatus.OK.value());
		responseBack.setResponseText("Category saved successfully");

		// fileStorageService.save(multipartFile);

		/*
		 * if (saveFile(pathToStoreImages, fileName, multipartFile)) {
		 * 
		 * return new ResponseEntity<>("",HttpStatus.OK); }
		 */

		return new ResponseEntity<>(responseBack, HttpStatus.OK);
	}

}
