package com.localmart.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"shopName","location","image"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopDetail {

	@Override
	public String toString() {
		return "ShopDetail [shopName=" + shopName + ", location=" + location + ", image=" + image + "]";
	}

	@JsonProperty("shopName")
	private String shopName;
	
	@JsonProperty("location")
	private String location;
	
	@JsonProperty("image")
	private String image;
}
