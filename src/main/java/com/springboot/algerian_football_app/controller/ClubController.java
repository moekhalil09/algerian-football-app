package com.springboot.algerian_football_app.controller;

import com.springboot.algerian_football_app.dto.ClubDto;
import com.springboot.algerian_football_app.dto.ManagerDto;
import com.springboot.algerian_football_app.model.Club;
import com.springboot.algerian_football_app.model.Player;
import com.springboot.algerian_football_app.repository.ClubRepository;
import com.springboot.algerian_football_app.service.ClubService;
import com.springboot.algerian_football_app.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/clubs")
@RequiredArgsConstructor
public class ClubController {
    private final ClubService clubService;
    private final ClubRepository clubRepository;
    private final ModelMapper modelMapper;
    private final PlayerService playerService;

    @GetMapping
    public String getAllClubs(Model model) {
        List<ClubDto> clubs = clubService.getAllClubs().stream()
                .map(club -> modelMapper.map(club, ClubDto.class))
                .collect(Collectors.toList());
        model.addAttribute("clubs", clubs);
        return "clubs";
    }

    @GetMapping("/{clubName}")
    public String getClubByName(@PathVariable String clubName, Model model) {
        Optional<ClubDto> clubOptional = clubService.getClubByName(clubName)
                .map(club -> modelMapper.map(club, ClubDto.class));
        if (clubOptional.isPresent()) {
            ClubDto clubDto = clubOptional.get();
            Club club = modelMapper.map(clubDto, Club.class);
            List<Player> players = playerService.getPlayerByClubId(club);
            model.addAttribute("club", clubOptional.get());
            model.addAttribute("players", players);
            return "club";
        } else {
            return "error/404";
        }
    }

    @GetMapping("/{clubName}/manager")
    public String getClubManager(@PathVariable String clubName, Model model) {
        String manager = clubService.getManager(clubName);
        ManagerDto managerDto = modelMapper.map(manager, ManagerDto.class);
        model.addAttribute("manager", managerDto);
        return "manager";
    }

}

