package com.uis.project.dtos.response;

import com.uis.project.persistences.models.Transaction;

import java.time.format.DateTimeFormatter;

public record TransactionResponse(
        Long id,
        String date,
        String time,
        String intersectionName,
        String patientName,
        String status,
        Float duration
) {
    public static TransactionResponse fromEntity(Transaction entity) {

        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");

        return new TransactionResponse(
                entity.getId(),
                entity.getCreatedAt().format(formatterDate),
                entity.getCreatedAt().format(formatterTime),
                entity.getIntersection().getLocation(),
                entity.getPatient().getFirstName() + " " + entity.getPatient().getFirstLastName(),
                entity.getStatus().toString(),
                30.0f
        );
    }
}
