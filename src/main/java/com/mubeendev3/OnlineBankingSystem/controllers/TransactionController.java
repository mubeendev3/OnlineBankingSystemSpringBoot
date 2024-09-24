package com.mubeendev3.OnlineBankingSystem.controllers;


import com.mubeendev3.OnlineBankingSystem.entities.Transaction;
import com.mubeendev3.OnlineBankingSystem.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    public Transaction transferFunds(@RequestBody Transaction transaction) {
        return transactionService.transferFunds(transaction);
    }

    @GetMapping("/{accountId}")
    public List<Transaction> getTransactionsByAccountId(@PathVariable int accountId) {
        return transactionService.getTransactionsByAccountId(accountId);
    }
}
