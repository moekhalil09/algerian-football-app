package com.springboot.algerian_football_app.dto;

import java.time.LocalDate;

public class ManagerDto {
    private String id;

    private String managerName;

    private LocalDate managerBd;

    private ClubDto managedClub;

    private String Nationality;

    private int games;

    private String preferredFormation;
}
