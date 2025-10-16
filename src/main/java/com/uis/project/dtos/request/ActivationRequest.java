package com.uis.project.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class ActivationRequest {

    @NotBlank
    @Setter
    private String RFIDCode;
    @NotBlank
    private String codeIntersection;

}
