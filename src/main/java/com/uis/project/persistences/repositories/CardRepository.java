package com.uis.project.persistences.repositories;

import com.uis.project.persistences.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findCardByRFIDCode(String rfidCode);

}
