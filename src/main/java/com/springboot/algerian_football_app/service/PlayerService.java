package com.springboot.algerian_football_app.service;

import com.mongodb.DBRef;
import com.springboot.algerian_football_app.dto.ClubDto;
import com.springboot.algerian_football_app.model.Club;
import com.springboot.algerian_football_app.model.Player;
import com.springboot.algerian_football_app.repository.PlayerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private MongoTemplate mongoTemplate;
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Optional<Player> getPlayerByName(String name) {
        return playerRepository.findByName(name);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getPlayerByClubId(Club club) {
        String clubId = club.getClubId();
        System.out.println("Club ID: " + clubId);
        Query query = new Query();
        query.addCriteria(new Criteria().orOperator(
                Criteria.where("playerClub.$id").is(clubId)
        ));

        System.out.println("Query: " + query.toString());

        return mongoTemplate.find(query, Player.class);
    }
}
