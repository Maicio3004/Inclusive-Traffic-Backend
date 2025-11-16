package com.uis.project.dtos.response;

import com.uis.project.persistences.models.Disability;
import com.uis.project.persistences.models.PatientDisability;

public record DisabilityResponse(
        String name,
        String description,
        String severity
) {
    public static DisabilityResponse fromEntity(Disability disability) {
        return new DisabilityResponse(
                disability.getName(),
                disability.getDescription(),
                null
        );
    }

    public static DisabilityResponse fromEntity(PatientDisability patientDisability) {
        return new DisabilityResponse(
                patientDisability.getDisability().getName(),
                patientDisability.getNotes(),
                patientDisability.getSeverity().toString()
        );
    }
}
