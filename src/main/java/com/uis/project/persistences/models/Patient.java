package com.uis.project.persistences.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient extends User {

    @Column(length = 355, nullable = false)
    private String disability;
    @Column(length = 355, nullable = false)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caregiver_id")
    private Caregiver caregiver;

    @OneToMany(mappedBy = "patient")
    private List<Card> cards;

    @OneToMany(mappedBy = "patient")
    private List<Transaction> transactions;

}
