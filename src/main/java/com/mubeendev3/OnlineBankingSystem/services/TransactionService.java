package com.mubeendev3.OnlineBankingSystem.services;


import com.mubeendev3.OnlineBankingSystem.entities.Transaction;
import com.mubeendev3.OnlineBankingSystem.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Create a new transaction
    public Transaction createTransaction(Transaction transaction) {
        transaction.setTransactionDate(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    // Get all transactions for a specific account
    public List<Transaction> getTransactionsByAccountId(int accountId) {
        return transactionRepository.findByAccountAccountId(accountId);
    }

    // Get transactions by type (DEPOSIT, WITHDRAWAL, TRANSFER)
    public List<Transaction> getTransactionsByType(Transaction.TransactionType type) {
        return transactionRepository.findByTransactionType(type);
    }

    // Method to transfer funds (assuming you have implemented this)
    public Transaction transferFunds(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
