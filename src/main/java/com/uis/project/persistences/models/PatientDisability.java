package com.uis.project.persistences.models;

import com.uis.project.persistences.models.enums.DisabilityLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient_disability")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDisability {

    @EmbeddedId
    private PatientDisabilityId id;

    @ManyToOne
    @MapsId("patientId")
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @MapsId("disabilityId")
    @JoinColumn(name = "disability_id")
    private Disability disability;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DisabilityLevel severity;

    @Column(length = 355)
    private String notes;

}
