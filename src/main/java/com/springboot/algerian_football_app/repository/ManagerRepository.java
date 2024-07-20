package com.springboot.algerian_football_app.repository;

import com.springboot.algerian_football_app.model.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ManagerRepository extends MongoRepository<Manager,String> {
}
