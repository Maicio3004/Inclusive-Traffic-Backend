package com.uis.project.services;

import com.uis.project.dtos.request.ActivationRequest;
import com.uis.project.dtos.response.ActivationResponse;
import com.uis.project.dtos.response.TransactionResponse;
import com.uis.project.persistences.models.*;
import com.uis.project.persistences.repositories.TransactionRepository;
import com.uis.project.services.mqtt.MqttPublisher;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final CardService cardService;
    private final IntersectionService intersectionService;
    private final TransactionFactory transactionFactory;
    private final MqttPublisher mqttPublisher;

    private final SseService sseService;


    private final static Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    @Transactional
    public void createTransaction(ActivationRequest activationRequest) {

        Intersection intersection = intersectionService.findByCode(activationRequest);

        Optional<Card> optionalCard = cardService.findByRFIDCode(activationRequest);

        Transaction transaction = transactionFactory.createTransaction(intersection, optionalCard);

        Transaction transactionSaved = save(transaction);

        sseService.sendEvent(TransactionResponse.fromEntity(transactionSaved, optionalCard));

        mqttPublisher.activateIntersection(ActivationResponse.fromTransaction(transactionSaved));
    }

    public Transaction save(Transaction transaction) {
        Transaction transactionSaved = transactionRepository.save(transaction);

        if(transactionSaved.isValid()) {
            LOGGER.info("Transaction created at: {}", transaction.getCreatedAt().toString());
        } else {
            LOGGER.warn("Transaction canceled. The traffic light will not be activated");
        }

        return transactionSaved;
    }

    public List<TransactionResponse> findHistory() {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        return transactionRepository.findAll(sort).stream()
                .map(TransactionResponse::fromEntity)
                .toList();
    }

}
