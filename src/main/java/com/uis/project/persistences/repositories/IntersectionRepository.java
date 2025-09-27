package com.uis.project.persistences.repositories;

import com.uis.project.persistences.models.Intersection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntersectionRepository extends JpaRepository<Intersection, Integer> {

    Optional<Intersection> findByCode(String code);

}
