package com.uis.project.persistences.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(indexes = {
        @Index(name = "idx_code", columnList = "code", unique = true)
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Intersection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;
    @Column(nullable = false, name = "code")
    private String code;
    @Column(nullable = false)
    private List<Float> coordinates;

    @OneToMany(mappedBy = "intersection")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "intersection")
    private List<TrafficLight> trafficLights;

}
