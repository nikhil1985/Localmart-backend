// Generated by delombok at Fri Jul 02 21:00:57 IST 2021
package com.localmart.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"clientInfo", "itemList"})
public class Payload {
	@JsonProperty("clientInfo")
	private ClinetInfo clientInfo;
	@JsonProperty("itemList")
	private List<ItemList> itemList;

	@Override
	public String toString() {
		return "Payload [clientInfo=" + clientInfo + ", itemList=" + itemList + "]";
	}

	@java.lang.SuppressWarnings("all")
	public ClinetInfo getClientInfo() {
		return this.clientInfo;
	}

	@java.lang.SuppressWarnings("all")
	public List<ItemList> getItemList() {
		return this.itemList;
	}

	@JsonProperty("clientInfo")
	@java.lang.SuppressWarnings("all")
	public void setClientInfo(final ClinetInfo clientInfo) {
		this.clientInfo = clientInfo;
	}

	@JsonProperty("itemList")
	@java.lang.SuppressWarnings("all")
	public void setItemList(final List<ItemList> itemList) {
		this.itemList = itemList;
	}

	@java.lang.SuppressWarnings("all")
	public Payload() {
	}

	@java.lang.SuppressWarnings("all")
	public Payload(final ClinetInfo clientInfo, final List<ItemList> itemList) {
		this.clientInfo = clientInfo;
		this.itemList = itemList;
	}
}
