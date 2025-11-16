package com.uis.project.dtos.response;

import com.uis.project.persistences.models.Caregiver;

public record CaregiverResponse(
        String name,
        String phone,
        String email
) {
    public static CaregiverResponse fromEntity(Caregiver caregiver) {
        return new CaregiverResponse(
                caregiver.getFirstName() + " " + caregiver.getFirstLastName(),
                caregiver.getPhone(),
                caregiver.getEmail()
        );
    }
}
