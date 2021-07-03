package com.localmart.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "STORE_PAYLOAD")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payload {
	@Transient
	public static final String SEQUENCE_NAME = "store_payload_seq";

	@Id
	private long id;
	
	private ClientInfo clientInfo;

	private List<ItemList> itemList;

	@Override
	public String toString() {
		return "Payload [clientInfo=" + clientInfo + ", itemList=" + itemList + "]";
	}

}
