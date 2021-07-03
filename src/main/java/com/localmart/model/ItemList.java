package com.localmart.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "brand", "measure", "quantity", "price","imageName" })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
		return "ItemList [name=" + name + ", brand=" + brand + ", scale=" + measure + ", scaleValue=" + quantity
				+ ", price=" + price + "]";
	}

}
