package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dto.Course;
import com.strangeye.dubalnebal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class CourseController {

	@Autowired
	CourseService courseService;

	// 주소로 코스 id를 입력 받는다.
	// 그리고 id로 코스를 검색해서 찾아온다.
	@GetMapping("/course/{id}")
	public ResponseEntity<?> course(@PathVariable String id) {
		Course course = courseService.findCourseById(id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
}
