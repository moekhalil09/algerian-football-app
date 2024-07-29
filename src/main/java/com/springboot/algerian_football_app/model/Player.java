package com.springboot.algerian_football_app.model;

import jakarta.persistence.Id;
import lombok.*;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Period;

@Document(collection = "players")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Player {

    @Id
    private String id;

    private String name;

    private String nationality;

    private String preferredFoot;

    private PlayerPosition position;

    private Integer shirtNumber;

    private LocalDate birthDate;

    public int getAge() {
        if (birthDate != null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    @DBRef
    public Club playerClub;

    private String playerUrlImage;
}
