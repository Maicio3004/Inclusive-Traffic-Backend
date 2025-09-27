package com.uis.project.persistences.repositories;

import com.uis.project.persistences.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
