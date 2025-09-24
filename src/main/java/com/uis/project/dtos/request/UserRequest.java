package com.uis.project.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotBlank(message = "First name is required")
    private String firstName;
    private String secondName;

    @NotBlank(message = "First last name is required")
    private String firstLastName;
    private String secondLastName;

    @Email(message = "Please, provide a valid email address")
    private String email;

    @NotBlank(message = "password cannot be blank")
    @Size(min = 8, max = 355, message = "Password must be between 8 and 355 characters")
    private String password;

    @Size(min = 8, max = 12, message = "Phone must be between 8 and 12 characters")
    private String phone;

}
