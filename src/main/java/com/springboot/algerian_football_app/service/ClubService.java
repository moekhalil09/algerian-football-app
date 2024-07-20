package com.springboot.algerian_football_app.service;

import com.springboot.algerian_football_app.model.Club;
import com.springboot.algerian_football_app.model.Manager;
import com.springboot.algerian_football_app.repository.ClubRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public Optional<Club> getClubByName(String clubName) {
        return clubRepository.findByClubName(clubName);
    }

    public Manager getManager(String clubName) {
        Club club = clubRepository.findByClubName(clubName)
                .orElseThrow(() -> new RuntimeException("Club not found"));
        return club.getManagedBy();
    }
}
