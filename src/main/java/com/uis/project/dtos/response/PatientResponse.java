package com.uis.project.dtos.response;

import com.uis.project.persistences.models.Patient;

import java.util.List;

public record PatientResponse(
        Long id,
        String name,
        String phone,
        String email,
        String notes,
        List<DisabilityResponse> disability,
        CaregiverResponse caregiver
) {
    public static PatientResponse fromEntity(Patient patient) {
        return new PatientResponse(
                patient.getId(),
                patient.getFirstName() + " " + patient.getFirstLastName(),
                patient.getPhone(),
                patient.getEmail(),
                patient.getNotes(),
                patient.getDisabilities().stream().map(DisabilityResponse::fromEntity).toList(),
                CaregiverResponse.fromEntity(patient.getCaregiver())
        );
    }
}
