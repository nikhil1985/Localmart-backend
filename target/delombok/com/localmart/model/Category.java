// Generated by delombok at Fri Jul 02 21:00:57 IST 2021
package com.localmart.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"categoryName", "image"})
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

	@java.lang.SuppressWarnings("all")
	public String getCategoryName() {
		return this.categoryName;
	}

	@java.lang.SuppressWarnings("all")
	public String getImage() {
		return this.image;
	}

	@java.lang.SuppressWarnings("all")
	public String getImageUri() {
		return this.imageUri;
	}

	@JsonProperty("categoryName")
	@java.lang.SuppressWarnings("all")
	public void setCategoryName(final String categoryName) {
		this.categoryName = categoryName;
	}

	@JsonProperty("image")
	@java.lang.SuppressWarnings("all")
	public void setImage(final String image) {
		this.image = image;
	}

	@JsonProperty("imageuri")
	@java.lang.SuppressWarnings("all")
	public void setImageUri(final String imageUri) {
		this.imageUri = imageUri;
	}

	@java.lang.SuppressWarnings("all")
	public Category() {
	}

	@java.lang.SuppressWarnings("all")
	public Category(final String categoryName, final String image, final String imageUri) {
		this.categoryName = categoryName;
		this.image = image;
		this.imageUri = imageUri;
	}
}
