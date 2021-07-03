package com.localmart.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
		return "ItemList [name=" + name + ", brand=" + brand + ", scale=" + measure + ", scaleValue=" + quantity
				+ ", price=" + price + "]";
	}

}
