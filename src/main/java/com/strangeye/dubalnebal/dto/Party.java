package com.strangeye.dubalnebal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Party {

	private Integer party_id;
	private Timestamp party_duration;
	private Timestamp party_created_at;
	private Timestamp party_depart_date;
	private Integer party_limit;
	private Integer course_id;
	private Integer user_id;
	private String party_title;

}