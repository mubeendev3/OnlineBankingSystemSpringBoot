package com.mubeendev3.OnlineBankingSystem.controllers;

import com.mubeendev3.OnlineBankingSystem.dto.AccountCreationDto;
import com.mubeendev3.OnlineBankingSystem.entities.Account;
import com.mubeendev3.OnlineBankingSystem.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public Account createAccount(@RequestBody AccountCreationDto account) {

        return accountService.createAccount(account);
    }

    @GetMapping("/{userId}")
    public List<Account> getAccountsByUserId(@PathVariable int userId) {
        return accountService.getAccountsByUserId(userId);
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable int accountId) {
        accountService.deleteAccount(accountId);
    }
}
