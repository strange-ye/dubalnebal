package com.strangeye.dubalnebal.dao;

import com.strangeye.dubalnebal.dto.Dog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DogDao {

	public List<Dog> selectDog(int dog_id);

	public int insertDog(Dog dog, String user_identifier);

	public int deleteDog(int dog_id);

	public int updateDog(Dog dog);
}
