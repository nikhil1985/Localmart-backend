package com.localmart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.localmart.controller.response.StoreResponse;
import com.localmart.entities.mapper.ClientInfoMapper;
import com.localmart.entities.mapper.ItemListMapper;
import com.localmart.entities.mapper.UserProfileMapper;
import com.localmart.model.Payload;
import com.localmart.model.UserProfile;
import com.localmart.repositories.PayloadRepository;
import com.localmart.repositories.UserProfileRepository;

@RestController
@CrossOrigin
@RequestMapping("/webapi")
public class GetApiController {
	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	PayloadRepository payloadRepository;
	
	@Autowired
	StoreResponse responseBack;
	

	@GetMapping(path = "/getUserProfile", produces = "application/json")
	public ResponseEntity<List<UserProfile>> getAllProfile() {
		List<UserProfile> userProfileModelList = userProfileRepository.findAll().stream()
				.map(userProfileEntity -> UserProfileMapper.INSTANCE.toUserProfileModel(userProfileEntity))
				.collect(Collectors.toList());

		return new ResponseEntity<>(userProfileModelList,HttpStatus.OK);
	}
	
	@GetMapping(path = "/getStoreInfo/{email}", produces = "application/json")
	public ResponseEntity<StoreResponse> savePayload(@PathVariable String email) {
		
		com.localmart.entities.Payload existingPayloadEntity = payloadRepository.findPayloadByEmailId(email);
		if(null == existingPayloadEntity) {
			responseBack.setResponceCode(HttpStatus.NOT_FOUND.value());
			responseBack.setResponseText("Email Id not already registered");
			return new ResponseEntity<>(responseBack,HttpStatus.OK);
		}

		
		List<com.localmart.model.ItemList> itemListModel = new ArrayList<>();
		ItemListMapper itemListMapper = ItemListMapper.INSTANCE;
		ClientInfoMapper clientInfoMapper = ClientInfoMapper.INSTANCE;

		com.localmart.model.ClinetInfo clientInfoModel = clientInfoMapper.toItemListModel(existingPayloadEntity.getClientInfo());

		for (com.localmart.entities.ItemList itemList : existingPayloadEntity.getItemList()) {
			itemListModel.add(itemListMapper.toItemListModel(itemList));
		}

		Payload payloadModel = new Payload();
		
		payloadModel.setClientInfo(clientInfoModel);
		payloadModel.setItemList(itemListModel);

		responseBack.setResponceCode(HttpStatus.OK.value());
		responseBack.setResponseText("Store detail save successfully");
		responseBack.setStoreName(payloadModel.getClientInfo().getStoreName());
		responseBack.setPayload(payloadModel);

		return new ResponseEntity<>(responseBack,HttpStatus.OK);
	}

	@GetMapping(path = "/getStoreInfo", produces = "application/json")
	public ResponseEntity<List<com.localmart.entities.Payload>> getAll() {
		
		List<com.localmart.entities.Payload> existingPayloadEntity = payloadRepository.findAll();
		return new ResponseEntity<>(existingPayloadEntity,HttpStatus.OK);
		
	}
	
	@DeleteMapping(path = "/deleteAll")
	public void deleteAllStore() {
		payloadRepository.deleteAll();
		
	}

}
