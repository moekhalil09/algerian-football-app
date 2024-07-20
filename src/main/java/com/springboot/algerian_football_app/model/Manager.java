package com.springboot.algerian_football_app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "manager")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manager {
    @Id
    private String id;

    private String managerName;

    private LocalDate managerBd;

    private Club managedClub;

    private String Nationality;

    private int games;

    private String preferredFormation;
}
