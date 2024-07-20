package com.springboot.algerian_football_app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;

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

    private Manager managedBy;
}
