package com.springboot.algerian_football_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Leagues")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class League {
    @Id
    private String id;

    private String name;


    @JsonIgnore
    private List<Club> clubs ;


}
