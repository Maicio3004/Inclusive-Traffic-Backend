package com.uis.project.services;

import com.uis.project.dtos.request.LoginRequest;
import com.uis.project.dtos.response.UserResponse;
import com.uis.project.exceptions.UserNotFoundException;
import com.uis.project.persistences.models.Caregiver;
import com.uis.project.persistences.models.Employee;
import com.uis.project.persistences.models.Patient;
import com.uis.project.persistences.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;

    public UserResponse login(LoginRequest loginRequest) {

        User user = userService.findUserByEmail(loginRequest.getEmail());

        if(!user.getPassword().equals(loginRequest.getPassword())) {
            throw new UserNotFoundException("Invalid username or password");
        }

        if(user instanceof Patient || user instanceof Caregiver) {
            throw new UserNotFoundException("Invalid username or password");
        }

        Map<String, Object> details = new HashMap<>();
        if(user instanceof Employee e) {
            details.put("Position", e.getRole());
        }

        return new UserResponse(
                user.getId(),
                user.getFirstName() + " " + user.getFirstLastName(),
                user.getEmail(),
                user.getClass().getSimpleName().toUpperCase(),
                details
        );
    }

}
