package com.springboot.algerian_football_app.repository;

import com.springboot.algerian_football_app.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PlayerRepository extends MongoRepository<Player, String> {
    Optional<Player> findByName(String name);
}
