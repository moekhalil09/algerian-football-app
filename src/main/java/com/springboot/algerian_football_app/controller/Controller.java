package com.springboot.algerian_football_app.controller;

import com.springboot.algerian_football_app.dto.ClubDto;
import com.springboot.algerian_football_app.dto.LeagueDto;
import com.springboot.algerian_football_app.dto.ManagerDto;
import com.springboot.algerian_football_app.dto.PlayerDto;
import com.springboot.algerian_football_app.model.Manager;
import com.springboot.algerian_football_app.service.ClubService;
import com.springboot.algerian_football_app.service.LeagueService;
import com.springboot.algerian_football_app.service.ManagerService;
import com.springboot.algerian_football_app.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/football")
@RequiredArgsConstructor
public class Controller {
    private final PlayerService playerService;

    private final ClubService clubService;

    private final ManagerService managerService;

    private final LeagueService leagueService;
    private final ModelMapper modelMapper;

    @GetMapping("/players")
    public List<PlayerDto> getAllPlayers() {
         return playerService.getAllPlayers().stream()
                .map(player ->modelMapper.map(player, PlayerDto.class))
                .collect(Collectors.toList());

    }

    @GetMapping("/player")
    public ResponseEntity<PlayerDto> getPlayerByName(@RequestParam String name) {

        Optional<PlayerDto> playerDto = playerService.getPlayerByName(name).map(player ->modelMapper
                .map(player, PlayerDto.class));
        return playerDto.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(null));
    }

    @GetMapping("/clubs")

    public List<ClubDto> getAllClubs() {
        return clubService.getAllClubs().stream().map(club -> modelMapper.map(club,ClubDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/clubs/{clubName}")

    public ResponseEntity<ClubDto> getClubByName(@PathVariable String clubName) {
        Optional<ClubDto> clubDto = clubService.getClubByName(clubName).map(club -> modelMapper.map(club,ClubDto.class));
        return clubDto.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(null));
    }

    @GetMapping("/{clubName}/manager")

    public ResponseEntity<ManagerDto> getClubManager(@PathVariable String clubName){
        Manager manager = clubService.getManager(clubName);
        ManagerDto managerDto = modelMapper.map(manager,ManagerDto.class);
        return ResponseEntity.ok(managerDto);
    }

    @GetMapping("/leagues")
    public List<LeagueDto> getAllLeagues() {
        return leagueService.getAllLeagues().stream().map(league -> modelMapper.map(league,LeagueDto.class)).collect(Collectors.toList());
    }

}
