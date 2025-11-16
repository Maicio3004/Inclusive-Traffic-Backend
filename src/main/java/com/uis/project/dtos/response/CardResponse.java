package com.uis.project.dtos.response;

import com.uis.project.persistences.models.Card;

public record CardResponse(
        Long id,
        String rfidCode,
        Long patientId,
        String patientName,
        String status,
        String IssuedAt
) {
    public static CardResponse fromEntity(Card card) {
        return new CardResponse(
                card.getId(),
                card.getRFIDCode(),
                card.getPatient().getId(),
                card.getPatient().getFirstName() + " " + card.getPatient().getFirstLastName(),
                card.getStatus().toString(),
                card.getIssuedAt().toString()
        );
    }
}
