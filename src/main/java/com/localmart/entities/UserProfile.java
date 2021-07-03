package com.localmart.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "USER_PROFILE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

	@Transient
	public static final String SEQUENCE_NAME = "user_profile_seq";

	@Id
	private long id;

	private String name;

	private String mobileNumber;

	private String email;

	private String customerType;

	@Override
	public String toString() {
		return "UserProfile [name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email + ", customerType="
				+ customerType + "]";
	}

}
