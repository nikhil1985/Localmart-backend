// Generated by delombok at Fri Jul 02 21:00:57 IST 2021
package com.localmart.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "brand", "measure", "quantity", "price", "imageName"})
public class ItemList {
	@JsonProperty("name")
	private String name;
	@JsonProperty("brand")
	private String brand;
	@JsonProperty("measure")
	private String measure;
	@JsonProperty("quantity")
	private String quantity;
	@JsonProperty("price")
	private String price;
	@JsonProperty("imageName")
	private String imageName;

	@Override
	public String toString() {
		return "ItemList [name=" + name + ", brand=" + brand + ", scale=" + measure + ", scaleValue=" + quantity + ", price=" + price + "]";
	}

	@java.lang.SuppressWarnings("all")
	public String getName() {
		return this.name;
	}

	@java.lang.SuppressWarnings("all")
	public String getBrand() {
		return this.brand;
	}

	@java.lang.SuppressWarnings("all")
	public String getMeasure() {
		return this.measure;
	}

	@java.lang.SuppressWarnings("all")
	public String getQuantity() {
		return this.quantity;
	}

	@java.lang.SuppressWarnings("all")
	public String getPrice() {
		return this.price;
	}

	@java.lang.SuppressWarnings("all")
	public String getImageName() {
		return this.imageName;
	}

	@JsonProperty("name")
	@java.lang.SuppressWarnings("all")
	public void setName(final String name) {
		this.name = name;
	}

	@JsonProperty("brand")
	@java.lang.SuppressWarnings("all")
	public void setBrand(final String brand) {
		this.brand = brand;
	}

	@JsonProperty("measure")
	@java.lang.SuppressWarnings("all")
	public void setMeasure(final String measure) {
		this.measure = measure;
	}

	@JsonProperty("quantity")
	@java.lang.SuppressWarnings("all")
	public void setQuantity(final String quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("price")
	@java.lang.SuppressWarnings("all")
	public void setPrice(final String price) {
		this.price = price;
	}

	@JsonProperty("imageName")
	@java.lang.SuppressWarnings("all")
	public void setImageName(final String imageName) {
		this.imageName = imageName;
	}

	@java.lang.SuppressWarnings("all")
	public ItemList() {
	}

	@java.lang.SuppressWarnings("all")
	public ItemList(final String name, final String brand, final String measure, final String quantity, final String price, final String imageName) {
		this.name = name;
		this.brand = brand;
		this.measure = measure;
		this.quantity = quantity;
		this.price = price;
		this.imageName = imageName;
	}
}
