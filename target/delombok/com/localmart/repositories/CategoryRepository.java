package com.localmart.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.localmart.entities.Category;

public interface CategoryRepository extends MongoRepository<Category, Integer>{
	
}
