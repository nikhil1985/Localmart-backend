package com.localmart.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "clientInfo", "itemList" })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payload {

	@JsonProperty("clientInfo")
	private ClinetInfo clientInfo;

	@JsonProperty("itemList")
	private List<ItemList> itemList;

	@Override
	public String toString() {
		return "Payload [clientInfo=" + clientInfo + ", itemList=" + itemList + "]";
	}

}
