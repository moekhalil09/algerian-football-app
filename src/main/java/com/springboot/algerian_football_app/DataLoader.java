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
import java.util.Collections;

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
        Manager manager = Manager.builder()
                .managerName("Matthias Jaissle")
                .managerBd(LocalDate.of(1988, Month.APRIL,5))
                .games(168)
                .preferredFormation("4-4-2")
                .Nationality("GER")
                .build();
        managerRepository.save(manager);
        Club club = Club.builder()
                .clubName("Al Ahly")
                .clubLeague("Saudi League")
                .managedBy(manager)
                .build();
        clubRepository.save(club);
        League league = League.builder()
                .name("Saudi League")
                .clubs(Collections.singletonList(club))
                .build();
        leagueRepository.save(league);
        if(playerRepository.count() == 0) {
          playerRepository.save(Player.builder()
                          .name("Riyadh Mahrez")
                          .nationality("Algerian")
                          .birthDate(LocalDate.of(2000,1,1))
                          .position(PlayerPosition.RW)
                          .shirtNumber(7)
                          .preferredFoot("Left")
                          .playerClub(club)
                  .build());
            System.out.println("Player added ");


        }
    }
}
