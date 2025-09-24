package com.uis.project.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {

    private Integer status;
    private String error;
    private String message;
    private LocalDateTime timestamp;

    public ApiError(Integer status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

}
