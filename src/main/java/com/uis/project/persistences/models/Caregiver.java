package com.uis.project.persistences.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Caregiver extends User {

    @Column(length = 355, nullable = false)
    private String address;

    @OneToMany(mappedBy = "caregiver")
    private List<Patient> patients;

}
