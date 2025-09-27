package com.uis.project.services;

import com.uis.project.persistences.models.Intersection;
import com.uis.project.persistences.repositories.IntersectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IntersectionService {

    private final IntersectionRepository intersectionRepository;

    public Optional<Intersection> findByCode(String code) {
        return intersectionRepository.findByCode(code);
    }

}
