package com.localmart.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "mNumber", "email", "cType" })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

	@JsonProperty("name")
	private String name;

	@JsonProperty("mNumber")
	private String mobileNumber;

	@JsonProperty("email")
	private String email;

	@JsonProperty("cType")
	private String customerType;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@Override
	public String toString() {
		return "UserProfile [name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email + ", customerType="
				+ customerType + "]";
	}

}
