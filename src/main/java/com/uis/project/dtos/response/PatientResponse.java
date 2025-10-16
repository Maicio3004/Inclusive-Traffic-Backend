package com.uis.project.dtos.response;

import com.uis.project.persistences.models.Patient;

public record PatientResponse(
        Long id,
        String firstName,
        String disability,
        String caregiverName,
        String caregiverPhone
) {
    public static PatientResponse fromEntity(Patient patient) {
        return new PatientResponse(
                patient.getId(),
                patient.getFirstName(),
                patient.getDisability().getName(),
                patient.getCaregiver().getFirstName(),
                patient.getCaregiver().getPhone()
        );
    }
}
