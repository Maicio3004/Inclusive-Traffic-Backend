package com.uis.project.persistences.models;

import com.uis.project.persistences.models.enums.DisabilityLevel;
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

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PatientDisability> disabilities;

    @Column(length = 355, nullable = false)
    private String address;

    @Column(length = 355)
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DisabilityLevel severity;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "caregiver_id")
    private Caregiver caregiver;

    @OneToMany(mappedBy = "patient")
    private List<Card> cards;

    @OneToMany(mappedBy = "patient")
    private List<Transaction> transactions;

}
