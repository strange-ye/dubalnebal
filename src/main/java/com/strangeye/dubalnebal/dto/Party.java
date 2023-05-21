package com.strangeye.dubalnebal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Party {

	private Integer party_id;
	private Timestamp party_duration;
	private String party_title;
	private String party_description;
	private Timestamp party_created_at;
	private Timestamp party_updated_at;
	private Integer party_limit;
	private int userId;

}
