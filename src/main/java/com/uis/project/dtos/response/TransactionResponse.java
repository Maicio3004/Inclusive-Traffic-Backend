package com.uis.project.dtos.response;

import com.uis.project.persistences.models.Card;
import com.uis.project.persistences.models.Transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public record TransactionResponse(
        Long id,
        LocalDateTime timestamp,
        String cardNumber,
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
                entity.getCreatedAt(),
                null,
                entity.getCreatedAt().format(formatterDate),
                entity.getCreatedAt().format(formatterTime),
                entity.getIntersection().getLocation(),
                entity.getPatient() == null ? null : entity.getPatient().getName(),
                entity.getStatus().toString(),
                entity.isValid() ? 30.0f : null
        );
    }

    public static TransactionResponse fromEntity(Transaction entity, Optional<Card> card) {

        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");

        return new TransactionResponse(
                entity.getId(),
                entity.getCreatedAt(),
                card.map(Card::getRFIDCode).orElse(null),
                entity.getCreatedAt().format(formatterDate),
                entity.getCreatedAt().format(formatterTime),
                entity.getIntersection().getLocation(),
                card.isPresent() ? entity.getPatient().getName() : null,
                entity.getStatus().toString(),
                30.0f
        );
    }
}
