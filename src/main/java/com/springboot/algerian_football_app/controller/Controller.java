package com.springboot.algerian_football_app.controller;

import com.springboot.algerian_football_app.model.Club;
import com.springboot.algerian_football_app.model.League;
import com.springboot.algerian_football_app.model.Manager;
import com.springboot.algerian_football_app.model.Player;
import com.springboot.algerian_football_app.service.ClubService;
import com.springboot.algerian_football_app.service.LeagueService;
import com.springboot.algerian_football_app.service.ManagerService;
import com.springboot.algerian_football_app.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/football")
@RequiredArgsConstructor
public class Controller {
    private final PlayerService playerService;

    private final ClubService clubService;

    private final ManagerService managerService;

    private final LeagueService leagueService;

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/player")
    public Optional<Player> getPlayerByName(@RequestParam String name) {
        return playerService.getPlayerByName(name);
    }

    @GetMapping("/clubs")
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/clubs/{clubName}")

    public Optional<Club> getClubByName(@PathVariable String clubName) {
        return clubService.getClubByName(clubName);
    }

    @GetMapping("/{clubName}/manager")

    public ResponseEntity<Manager> getClubManager(@PathVariable String clubName){
        Manager manager = clubService.getManager(clubName);
        return ResponseEntity.ok(manager);
    }

    @GetMapping("/leagues")
    public List<League> getAllLeagues() {
        return leagueService.getAllLeagues();
    }

}
