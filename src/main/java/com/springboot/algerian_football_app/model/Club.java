package com.springboot.algerian_football_app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;
import java.util.List;

@Document(collection = "club")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class Club {
    @Id
    private String clubId;

    private String clubName;

    private LocalDate clubCreationDate;

    private String clubLeague;

    @DBRef
    private String managedBy;


    @DBRef
    private List<Player> players;

    private Integer totalPlayers;

    private List<String> tournaments;

    private String stadium;

    private String city;

    private String clubUrl;
}
