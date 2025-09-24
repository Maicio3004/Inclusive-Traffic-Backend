package com.uis.project.dtos.request;

import com.uis.project.persistences.models.enums.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest extends UserRequest {

    private Role role;

}
