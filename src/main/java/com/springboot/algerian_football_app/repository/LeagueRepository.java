package com.springboot.algerian_football_app.repository;

import com.springboot.algerian_football_app.model.League;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LeagueRepository extends MongoRepository<League,String> {

    Optional<League> findByName(String saudiLeague);
}
