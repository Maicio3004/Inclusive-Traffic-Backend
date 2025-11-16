package com.uis.project.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class LoginRequest {

    @Email(message = "Please, provide a valid email address")
    private String email;

    @NotBlank(message = "password cannot be blank")
    @Size(min = 8, max = 355, message = "Password must be between 8 and 355 characters")
    private String password;
}
