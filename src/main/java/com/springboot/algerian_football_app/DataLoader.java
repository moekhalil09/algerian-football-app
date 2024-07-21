package com.springboot.algerian_football_app;

import com.springboot.algerian_football_app.model.*;
import com.springboot.algerian_football_app.repository.ClubRepository;
import com.springboot.algerian_football_app.repository.LeagueRepository;
import com.springboot.algerian_football_app.repository.ManagerRepository;
import com.springboot.algerian_football_app.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final PlayerRepository playerRepository;
    private final ClubRepository clubRepository;
    private final ManagerRepository managerRepository;
    private final LeagueRepository leagueRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DataLoader is running...");

        // Check if a Manager with a specific name already exists
        Optional<Manager> existingManager = managerRepository.findByManagerName("Matthias Jaissle");
        Manager manager;
        if (existingManager.isEmpty()) {
            manager = Manager.builder()
                    .managerName("Matthias Jaissle")
                    .managerBd(LocalDate.of(1988, Month.APRIL, 5))
                    .games(168)
                    .preferredFormation("4-4-2")
                    .Nationality("GER")
                    .build();
            managerRepository.save(manager);
        } else {
            manager = existingManager.get();
        }

        // Check if a Club with a specific name already exists
        Optional<Club> existingClub = clubRepository.findByClubName("Al Ahly");
        Club club;
        if (existingClub.isEmpty()) {
            club = Club.builder()
                    .clubName("Al Ahly")
                    .managedBy(manager)
                    .build();
            clubRepository.save(club);
        } else {
            club = existingClub.get();
        }

        // Check if a League with a specific name already exists
        Optional<League> existingLeague = leagueRepository.findByName("Saudi League");
        League league;
        if (existingLeague.isEmpty()) {
            league = League.builder()
                    .name("Saudi League")
                    .clubs(Collections.singletonList(club))
                    .build();
            leagueRepository.save(league);
        } else {
            league = existingLeague.get();
        }

        // Update Club's league and save
        club.setClubLeague(league.getName());
        clubRepository.save(club);

        // Update Manager's managed club and save
        manager.setManagedClub(club.getClubName());
        managerRepository.save(manager);

        // Check if a Player with a specific name already exists
        Optional<Player> existingPlayer = playerRepository.findByName("Riyadh Mahrez");
        Player player;
        if (existingPlayer.isEmpty()) {
            player = playerRepository.save(Player.builder()
                    .name("Riyadh Mahrez")
                    .nationality("Algerian")
                    .birthDate(LocalDate.of(2000, 1, 1))
                    .position(PlayerPosition.RW)
                    .shirtNumber(7)
                    .preferredFoot("Left")
                    .playerClub(club)
                    .build());
            playerRepository.save(player);
            List<Player> players = club.getPlayers() !=null ? club.getPlayers() : new ArrayList<Player>();
            players.add(player);
            club.setPlayers(players);
            clubRepository.save(club);
            System.out.println("Player added");
        } else {
            System.out.println("Player already exists");
        }

    }
}
