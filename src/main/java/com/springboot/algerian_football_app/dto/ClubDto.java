package com.springboot.algerian_football_app.dto;

import com.springboot.algerian_football_app.model.Manager;
import com.springboot.algerian_football_app.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ClubDto {


    private String clubId;

    private String clubName;

    private LocalDate clubCreationDate;

    private LeagueDto clubLeague;

    private ManagerDto managedBy;


}
