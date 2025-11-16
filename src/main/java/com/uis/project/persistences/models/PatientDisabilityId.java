package com.uis.project.persistences.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class PatientDisabilityId implements Serializable {

    private Long patientId;
    private Long disabilityId;

}
