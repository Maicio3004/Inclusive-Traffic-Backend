package com.uis.project.services;

import com.uis.project.dtos.request.ActivationRequest;
import com.uis.project.persistences.models.*;
import com.uis.project.persistences.models.enums.CardStatus;
import com.uis.project.persistences.repositories.TransactionRepository;
import com.uis.project.services.mqtt.MqttPublisher;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final CardService cardService;
    private final IntersectionService intersectionService;
    private final TransactionFactory transactionFactory;
    private final MqttPublisher mqttPublisher;

    private final static Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    public void createTransaction(ActivationRequest activationRequest) {

        Intersection intersection = intersectionService
                .findByCode(activationRequest.codeIntersection())
                .orElseThrow(() -> {
                    LOGGER.error("Invalid Intersection Code: {}", activationRequest.codeIntersection());
                    return new RuntimeException("Intersection not found");
                });

        Optional<Card> optionalCard = cardService
                .findByRFIDCode(activationRequest.RFIDCode());

        Transaction transaction = optionalCard
                .map(card -> {
                    if(card.getStatus().equals(CardStatus.ACTIVE)) {
                        return transactionFactory.createSucessfulTransaction(card.getPatient(), intersection);
                    } else {
                        return transactionFactory.createInactiveCardTransaction(card, intersection);
                    }
                })
                .orElseGet(() -> transactionFactory.createCardNotFoundTransaction(intersection));

        transactionRepository.save(transaction);

        LOGGER.info("Transaction created at: {}", transaction.getCreatedAt().toString());
    }

}
