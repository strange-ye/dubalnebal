package com.strangeye.dubalnebal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SerchCondition {

	private String key = "none";
	private String word;
	private String orderBy = "none";
	private String orderByDir;
}
