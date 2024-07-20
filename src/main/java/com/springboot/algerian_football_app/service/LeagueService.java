package com.springboot.algerian_football_app.service;

import com.springboot.algerian_football_app.model.League;
import com.springboot.algerian_football_app.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LeagueService {
    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }
}
