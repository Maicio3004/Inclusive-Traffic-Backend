package com.uis.project.controllers;

import com.uis.project.dtos.request.EmployeeRequest;
import com.uis.project.dtos.response.PatientResponse;
import com.uis.project.dtos.response.UserResponse;
import com.uis.project.services.EmployeeService;
import com.uis.project.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final EmployeeService employeeService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createEmployee
            (@RequestBody EmployeeRequest employee) {

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        return ResponseEntity.ok(userService.findAllPatients());
    }


}
