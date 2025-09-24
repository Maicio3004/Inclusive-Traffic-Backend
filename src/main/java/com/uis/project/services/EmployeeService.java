package com.uis.project.services;

import com.uis.project.dtos.request.EmployeeRequest;
import com.uis.project.dtos.response.UserResponse;
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

    public UserResponse createEmployee(EmployeeRequest employee) {

        Employee employeeEntity = builtEmployee(employee);

        User userSaved = userService.createUser(employeeEntity);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(userSaved.getId());
        userResponse.setEmail(userSaved.getEmail());
        userResponse.setType(userSaved.getClass().getSimpleName().toUpperCase());

        Map<String, Object> details = new HashMap<>();
        if(userSaved instanceof Employee e) {
            details.put("Position", e.getRole());
        }
        userResponse.setDetails(details);
        
        return userResponse;
    }

    private Employee builtEmployee(EmployeeRequest employee) {
        Employee employeeEntity = new Employee();
        employeeEntity.setRole(employee.getRole());

        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setSecondLastName(employee.getSecondLastName());
        employeeEntity.setFirstLastName(employee.getFirstLastName());
        employeeEntity.setSecondLastName(employee.getSecondLastName());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setPassword(employee.getPassword());
        employeeEntity.setPhone(employee.getPhone());
        return employeeEntity;
    }

}
