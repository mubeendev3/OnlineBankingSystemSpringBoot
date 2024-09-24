package com.mubeendev3.OnlineBankingSystem.repositories;

import com.mubeendev3.OnlineBankingSystem.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    // Find transactions by account ID
    List<Transaction> findByAccountAccountId(int accountId);

    // Optional: Find transactions by transaction type (DEPOSIT, WITHDRAWAL, TRANSFER)
    List<Transaction> findByTransactionType(Transaction.TransactionType transactionType);

}
