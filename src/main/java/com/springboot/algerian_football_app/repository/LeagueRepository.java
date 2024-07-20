package com.springboot.algerian_football_app.repository;

import com.springboot.algerian_football_app.model.League;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueRepository extends MongoRepository<League,String> {

}
