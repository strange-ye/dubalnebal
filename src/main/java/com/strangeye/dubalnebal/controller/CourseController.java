package com.strangeye.dubalnebal.controller;

import com.strangeye.dubalnebal.dao.CourseDao;
import com.strangeye.dubalnebal.dto.Course;
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
	CourseDao courseDao;

	@GetMapping("/course/{id}")
	public ResponseEntity<?> course(@PathVariable String id) {
		Course course = courseDao.findPoemById(String id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
}
