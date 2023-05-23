package com.strangeye.dubalnebal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	private int course_id;
	private String course_name;
	private String course_path;
	private String course_location;
	private String course_level;
	private String course_km;
	private String course_explain;
	private String course_time;

}
