package com.uis.project.controllers;

import com.uis.project.dtos.request.EmployeeRequest;
import com.uis.project.dtos.response.UserResponse;
import com.uis.project.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createEmployee
            (@RequestBody EmployeeRequest employee) {

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }


}
