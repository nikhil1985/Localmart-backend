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
public class ClientInfo {
	@Transient
	public static final String SEQUENCE_NAME = "client_info_seq";

	@Id
	private long id;

	private String locationName;

	private String categoryName;

	private String mobileNumber;

	private String name;
	private String firstName;
	private String lastName;
	private String email;
	private String imageUrl;
	private String storeName;

	@Override
	public String toString() {
		return "ClinetInfo [name=" + name + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", imageUrl=" + imageUrl + ", storeName=" + storeName + "]";
	}

}
