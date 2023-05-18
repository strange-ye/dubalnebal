package com.strangeye.dubalnebal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private int id;
	private String userId;
	private String password;
	private String nickname;
	private String profileImage;

}
