package com.localmart.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	private String categoryName;
	private String image;
	
	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + "]";
	}
}
