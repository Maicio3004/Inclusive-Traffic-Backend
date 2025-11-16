package com.uis.project.services;

import com.uis.project.dtos.request.ActivationRequest;
import com.uis.project.dtos.response.CardResponse;
import com.uis.project.persistences.models.Card;
import com.uis.project.persistences.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public Optional<Card> findByRFIDCode(String rfidCode) {
        return cardRepository.findCardByRFIDCode(rfidCode);
    }

    public Optional<Card> findByRFIDCode(ActivationRequest activationRequest) {
        String rfidCode = activationRequest.getRfidCode().toUpperCase();
        return findByRFIDCode(rfidCode);
    }

    public List<CardResponse> findAll() {
        return cardRepository.findAll().stream()
                .map(CardResponse::fromEntity)
                .toList();
    }

}
