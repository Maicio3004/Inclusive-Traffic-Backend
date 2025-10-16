package com.uis.project.services;

import com.uis.project.dtos.response.PatientResponse;
import com.uis.project.exceptions.UserNotFoundException;
import com.uis.project.persistences.models.Patient;
import com.uis.project.persistences.models.User;
import com.uis.project.persistences.repositories.PatientRepository;
import com.uis.project.persistences.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements CrudUserService {

    private final UserRepository userRepository;
    private final PatientRepository patientRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("email", email));
    }

    public List<PatientResponse> findAllPatients() {
        return patientRepository.findAll().stream()
                .map(PatientResponse::fromEntity)
                .toList();
    }
}
