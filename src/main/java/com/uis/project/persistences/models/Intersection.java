package com.uis.project.persistences.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Intersection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private List<Float> coordinates;

    @OneToMany(mappedBy = "intersection")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "intersection")
    private List<TrafficLight> trafficLights;

}
