package com.localmart.controller.response;

import java.util.List;

import org.springframework.stereotype.Service;

import com.localmart.model.Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class StoreResponse {

	private Integer responceCode;
	private String responseText;
	private String storeName;
	private Payload payload;
	private List<Object> payloadList;
	
	@Override
	public String toString() {
		return "StoreResponse [responceCode=" + responceCode + ", responseText=" + responseText + ", storeName="
				+ storeName + "]";
	}
}
