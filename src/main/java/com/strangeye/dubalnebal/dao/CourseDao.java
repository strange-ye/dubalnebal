package com.strangeye.dubalnebal.dao;

import com.strangeye.dubalnebal.dto.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseDao {
	Course selectOne(String id);
}
