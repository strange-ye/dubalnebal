package com.strangeye.dubalnebal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Party {

	private int id;
	private String title;
	private String description;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private int userId;

}
