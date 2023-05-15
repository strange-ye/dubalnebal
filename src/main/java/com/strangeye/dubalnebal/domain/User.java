package com.strangeye.dubalnebal.domain;

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
