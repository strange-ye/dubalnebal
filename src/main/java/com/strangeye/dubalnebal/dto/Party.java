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
	private String party_duration;
	private String party_created_at;
	private String party_depart_date;
	private Integer party_limit;
	private Integer course_id;
	private Integer user_id;
	private String party_title;
	private int user_count;
	private String course_name;
	private String course_path;
	private String course_location;
	private String course_level;
	private String course_km;
	private String course_explain;
	private String course_time;

}