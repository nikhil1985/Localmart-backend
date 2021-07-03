package com.localmart.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"categoryName","image"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	
@JsonProperty("categoryName")	
private String categoryName;

@JsonProperty("image")
private String image;

@JsonProperty("imageuri")
private String imageUri;

@Override
	public String toString() {
		return "Category [category=" + categoryName + "]";
	}
   
}
