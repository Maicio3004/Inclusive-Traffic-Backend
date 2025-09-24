package com.uis.project.controllers;

import com.uis.project.persistences.models.User;
import com.uis.project.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    public ResponseEntity<User> createEmployee() {

    }


}
