package com.strangeye.dubalnebal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Integer user_id;
	private String user_identifier;
	private String user_password;
	private String user_name;
	private String user_email;
	private	Integer party_id;
	private String user_image;

}