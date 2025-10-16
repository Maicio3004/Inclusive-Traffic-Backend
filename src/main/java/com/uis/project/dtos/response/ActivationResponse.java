package com.uis.project.dtos.response;

import com.uis.project.persistences.models.Transaction;

public record ActivationResponse(
        Boolean payload,
        String endTopic
) {
    public static ActivationResponse fromTransaction(Transaction transaction) {
        return new ActivationResponse(
                transaction.isValid(),
                transaction.getIntersection().getCode()
        );
    }
}
