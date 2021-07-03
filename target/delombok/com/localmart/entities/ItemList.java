// Generated by delombok at Fri Jul 02 21:00:57 IST 2021
package com.localmart.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class ItemList {
	@Transient
	public static final String SEQUENCE_NAME = "item_list_seq";
	@Id
	private long id;
	private String name;
	private String brand;
	private String measure;
	private String quantity;
	private String price;
	private String imageName;

	@Override
	public String toString() {
		return "ItemList [name=" + name + ", brand=" + brand + ", scale=" + measure + ", scaleValue=" + quantity + ", price=" + price + "]";
	}

	@java.lang.SuppressWarnings("all")
	public long getId() {
		return this.id;
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

	@java.lang.SuppressWarnings("all")
	public void setId(final long id) {
		this.id = id;
	}

	@java.lang.SuppressWarnings("all")
	public void setName(final String name) {
		this.name = name;
	}

	@java.lang.SuppressWarnings("all")
	public void setBrand(final String brand) {
		this.brand = brand;
	}

	@java.lang.SuppressWarnings("all")
	public void setMeasure(final String measure) {
		this.measure = measure;
	}

	@java.lang.SuppressWarnings("all")
	public void setQuantity(final String quantity) {
		this.quantity = quantity;
	}

	@java.lang.SuppressWarnings("all")
	public void setPrice(final String price) {
		this.price = price;
	}

	@java.lang.SuppressWarnings("all")
	public void setImageName(final String imageName) {
		this.imageName = imageName;
	}

	@java.lang.SuppressWarnings("all")
	public ItemList() {
	}

	@java.lang.SuppressWarnings("all")
	public ItemList(final long id, final String name, final String brand, final String measure, final String quantity, final String price, final String imageName) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.measure = measure;
		this.quantity = quantity;
		this.price = price;
		this.imageName = imageName;
	}
}
