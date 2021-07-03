package com.localmart.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.localmart.entities.Payload;

public interface PayloadRepository extends MongoRepository<Payload, Integer>{
	
	@Query("{'clientInfo.email' : ?0}")
	Payload findPayloadByEmailId(String emailId);

	@Query("{'clientInfo.categoryName' : ?0}")
	List<Payload> findPayloadByCategory(String category);

}
