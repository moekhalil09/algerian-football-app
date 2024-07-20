package com.springboot.algerian_football_app.repository;

import com.springboot.algerian_football_app.model.Club;
import com.springboot.algerian_football_app.model.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClubRepository extends MongoRepository<Club,String> {

    Optional<Club> findByClubName(String clubName);

}
