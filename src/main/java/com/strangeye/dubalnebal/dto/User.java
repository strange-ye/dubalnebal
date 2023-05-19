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

	private Integer userId;
	private String userIdentifier;
	private String userPassword;
	private String userName;
	private String userEmail;
	private	Integer partyId;
	private String userImage;

}