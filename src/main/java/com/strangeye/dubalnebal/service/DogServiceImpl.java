package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dao.DogDao;
import com.strangeye.dubalnebal.dto.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

	@Autowired
	DogDao dogdao;


	@Override
	public List<Dog> getDog(int dog_id) {
		return dogdao.selectDog(dog_id);
	}

	@Override
	public Boolean writeDog(Dog dog, String user_identifier) {
		return dogdao.insertDog(dog, user_identifier) == 1;
	}

	@Override
	public Boolean removeDog(int dog_id) {
		return dogdao.deleteDog(dog_id) == 1;
	}

	@Override
	public Boolean modifyDog(Dog dog) {
		return dogdao.updateDog(dog) == 1;
	}
}
