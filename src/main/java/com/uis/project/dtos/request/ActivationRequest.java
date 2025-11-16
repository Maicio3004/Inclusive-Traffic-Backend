package com.uis.project.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ActivationRequest {

    @JsonProperty("RFIDCode")
    @NotBlank
    private String rfidCode;
    @NotBlank
    private String codeIntersection;

}
