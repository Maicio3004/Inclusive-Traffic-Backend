package com.uis.project.services;

import com.uis.project.persistences.models.Card;
import com.uis.project.persistences.models.Intersection;
import com.uis.project.persistences.models.Patient;
import com.uis.project.persistences.models.Transaction;
import com.uis.project.persistences.models.enums.TransactionStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionFactory {

    public Transaction createSucessfulTransaction(Patient patient, Intersection intersection) {
        Transaction transaction = baseTransaction(intersection);
        transaction.setPatient(patient);
        transaction.setStatus(TransactionStatus.COMPLETED);
        transaction.setDescription("Transaction created successfully");
        return transaction;
    }

    public Transaction createCardNotFoundTransaction(Intersection intersection) {
        Transaction transaction = baseTransaction(intersection);
        transaction.setStatus(TransactionStatus.CANCELED);
        transaction.setDescription("Transaction canceled. Card does not exist");
        return transaction;
    }

    public Transaction createInactiveCardTransaction(Card card, Intersection intersection) {
        Transaction transaction = baseTransaction(intersection);
        transaction.setStatus(TransactionStatus.CANCELED);
        transaction.setDescription("Transaction canceled. Card status is: " + card.getStatus().name());
        return transaction;
    }

    private Transaction baseTransaction(Intersection intersection) {
        Transaction transaction = new Transaction();
        transaction.setIntersection(intersection);
        transaction.setCreatedAt(LocalDateTime.now());
        return transaction;
    }

}
