package com.localmart.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.ServletContextResource;

import com.localmart.controller.response.StoreResponse;
import com.localmart.entities.Payload;
import com.localmart.entities.mapper.CategoryMapper;
import com.localmart.file.service.FileStorageService;
import com.localmart.model.Categories;
import com.localmart.model.Category;
import com.localmart.model.ShopDetail;
import com.localmart.repositories.CategoryRepository;
import com.localmart.repositories.PayloadRepository;

@RestController
@CrossOrigin
@RequestMapping("/webapi")
public class MobileController {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	FileStorageService fileStorageService;

	@Autowired
	PayloadRepository payloadRepository;

	@Autowired
	StoreResponse responseBack;

	@PostMapping(path = "/saveCategories", consumes = "application/json", produces = "application/json")
	public ResponseEntity<StoreResponse> saveCategory(@RequestBody Categories categoryModel) {
		List<com.localmart.entities.Category> categoryEntityList = new ArrayList<com.localmart.entities.Category>();
		CategoryMapper categorymapper = CategoryMapper.INSTANCE;

		for (Category category : categoryModel.getCategories()) {
			categoryEntityList.add(categorymapper.toCategoryEntity(category));
		}
		categoryRepository.deleteAll();
		categoryRepository.saveAll(categoryEntityList);
		responseBack.setResponceCode(HttpStatus.OK.value());
		responseBack.setResponseText("Category saved successfully");
		return new ResponseEntity<>(responseBack, HttpStatus.OK);
	}

	@GetMapping(path = "/getCategories", produces = "application/json")
	public ResponseEntity<Categories> getCategory() {
		List<Category> categoryModelList = new ArrayList<Category>();
		CategoryMapper categorymapper = CategoryMapper.INSTANCE;
		List<com.localmart.entities.Category> categoryEntityList = categoryRepository.findAll();
		for (com.localmart.entities.Category categoryEntity : categoryEntityList) {
			Category model = categorymapper.toCategoryModel(categoryEntity);
			Resource resource = new ServletContextResource(servletContext, model.getImage());
			try {
				model.setImageUri(resource.getFile().toURI().getPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			categoryModelList.add(model);
		}

		Categories categoryList = new Categories(categoryModelList);

		responseBack.setResponceCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(categoryList, HttpStatus.OK);
	}

	@GetMapping(path = "/getImage/{filename}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getFile(@PathVariable String filename) {
		System.out.println("requested " + filename);
		String pathToStoreImages = new ClassPathResource("images/").getPath();
		Path imagePath = Paths.get(pathToStoreImages).resolve(filename);
		Resource resource = null;
		InputStream in = null;
		byte[] imgageArray = null;
		try {
			resource = new UrlResource(imagePath.toUri());
			in = new FileInputStream(resource.getURI().getPath());

			imgageArray = IOUtils.toByteArray(in);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (null == resource) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imgageArray);
	}

	@GetMapping(path = "/getShops/{categoryType}", produces = "application/json")
	public ResponseEntity<List<ShopDetail>> getShopByCategory(@PathVariable String categoryType) {
		List<Payload> shopLists = payloadRepository.findPayloadByCategory(categoryType);
		List<ShopDetail> shopDetailByCategory = new ArrayList<ShopDetail>();
		for (Payload shop : shopLists) {
			ShopDetail shopDetail = new ShopDetail();
			shopDetail.setShopName(shop.getClientInfo().getStoreName());
			shopDetail.setLocation(shop.getClientInfo().getLocationName());
			shopDetail.setImage("abc");
			shopDetailByCategory.add(shopDetail);
			shopDetailByCategory.add(shopDetail);
			shopDetailByCategory.add(shopDetail);
			shopDetailByCategory.add(shopDetail);
			shopDetailByCategory.add(shopDetail);
			shopDetailByCategory.add(shopDetail);
			shopDetailByCategory.add(shopDetail);

		}
		return new ResponseEntity<>(shopDetailByCategory, HttpStatus.OK);
	}
}
