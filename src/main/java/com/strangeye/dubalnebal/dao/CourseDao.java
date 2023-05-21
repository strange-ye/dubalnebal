package com.strangeye.dubalnebal.dao;

import com.strangeye.dubalnebal.dto.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseDao {
	// 코스 id로 찾아오기.
	Course selectOne(String id);
}
