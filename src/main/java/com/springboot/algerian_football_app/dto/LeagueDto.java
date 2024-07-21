package com.springboot.algerian_football_app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.algerian_football_app.model.Club;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueDto {
    private String id;

    private String name;

    private List<ClubDto> clubs ;
}
