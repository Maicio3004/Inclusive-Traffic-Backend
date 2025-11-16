package com.uis.project.services;

import com.uis.project.dtos.request.EmployeeRequest;
import com.uis.project.dtos.response.UserResponse;
import com.uis.project.mappers.EmployeeMapper;
import com.uis.project.persistences.models.Employee;
import com.uis.project.persistences.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final UserService userService;

    public UserResponse createEmployee(EmployeeRequest employeeRequest) {

        Employee employee = EmployeeMapper.toEntity(employeeRequest);

        User userSaved = userService.createUser(employee);

        Map<String, Object> details = new HashMap<>();
        if(userSaved instanceof Employee e) {
            details.put("Position", e.getRole());
        }

        return new UserResponse(
                userSaved.getId(),
                userSaved.getFirstName(),
                userSaved.getEmail(),
                userSaved.getClass().getSimpleName().toUpperCase(),
                details
        );
    }

}
