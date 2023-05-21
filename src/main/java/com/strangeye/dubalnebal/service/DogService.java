package com.strangeye.dubalnebal.service;

import com.strangeye.dubalnebal.dto.Dog;

import java.util.List;

public interface DogService {

	public List<Dog> getDog(int dog_id);

	public Boolean writeDog(Dog dog, String user_identifier);

	public Boolean removeDog(int dog_id);

	public Boolean modifyDog(Dog dog);
}
