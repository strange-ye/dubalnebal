package com.strangeye.dubalnebal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
	private int dog_id;
	private String dog_name;
	private String dog_gender;
	private int dog_age;
	private String dog_type;
	private String dog_image;
	private int user_id;
	private int user_identifier;
}
