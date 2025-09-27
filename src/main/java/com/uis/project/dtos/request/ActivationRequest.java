package com.uis.project.dtos.request;

public record ActivationRequest(
        String RFIDCode,
        String codeIntersection
) {
}
