package com.springboot.algerian_football_app.dto;

import com.springboot.algerian_football_app.model.PlayerPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class PlayerDto {
    private String id;

    private String name;

    private String nationality;

    private String preferredFoot;

    private PlayerPosition position;

    private int shirtNumber;

    private LocalDate birthDate;

    private ClubDto playerClub;

    private String playerUrlImage;

}
