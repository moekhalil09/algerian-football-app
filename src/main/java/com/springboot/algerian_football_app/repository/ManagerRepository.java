package com.springboot.algerian_football_app.repository;

import com.springboot.algerian_football_app.model.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ManagerRepository extends MongoRepository<Manager,String> {
    Optional<Manager> findByManagerName(String matthiasJaissle);
}
