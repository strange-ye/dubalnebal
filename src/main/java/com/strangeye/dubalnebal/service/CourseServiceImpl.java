package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.CourseDao;
import com.strangeye.dubalnebal.dto.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;
	@Override
	public Course findCourseById(String id) {
		return courseDao.selectOne(id);
	}

}
