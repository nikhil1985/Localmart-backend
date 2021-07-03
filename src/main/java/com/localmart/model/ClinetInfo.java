package com.localmart.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "firstName", "lastName", "email", "imageUrl", "storeName", "categoryName",
		"locationName","mobileNumber" })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClinetInfo {

	@JsonProperty("locationName")
	private String locationName;

	@JsonProperty("categoryName")
	private String categoryName;
	
	@JsonProperty("mobileNumber")
	private String mobileNumber;
	

	@JsonProperty("name")
	private String name;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("imageUrl")
	private String imageUrl;
	@JsonProperty("storeName")
	private String storeName;

	@Override
	public String toString() {
		return "ClinetInfo [name=" + name + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", imageUrl=" + imageUrl + ", storeName=" + storeName + "]";
	}
}
