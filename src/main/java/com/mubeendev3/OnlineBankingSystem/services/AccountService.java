package com.mubeendev3.OnlineBankingSystem.services;


import com.mubeendev3.OnlineBankingSystem.dto.AccountCreationDto;
import com.mubeendev3.OnlineBankingSystem.entities.Account;
import com.mubeendev3.OnlineBankingSystem.entities.User;
import com.mubeendev3.OnlineBankingSystem.repositories.AccountRepository;
import com.mubeendev3.OnlineBankingSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    // Create a new account
    public Account createAccount(AccountCreationDto account) {

        Optional<User> user = userRepository.findById(account.getUserId());
        Account account1 = new Account();
        account1.setUser(user.get());
        account1.setAccountType(account.getAccountType());
        account1.setBalance(account.getBalance());
        return accountRepository.save(account1);
    }

    // Find all accounts for a specific user
    public List<Account> getAccountsByUserId(int userId) {
        return accountRepository.findByUserUserId(userId);
    }

    // Find all accounts for a specific user
    public List<Account> getAccounts(int userId) {
        return accountRepository.getAccountByUser(userId);
    }

    // Find an account by ID
    public Account getAccountById(int accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    // Update the balance of an account
    public Account updateAccountBalance(int accountId, BigDecimal newBalance) {
        Account account = getAccountById(accountId);
        if (account != null) {
            account.setBalance(newBalance);
            return accountRepository.save(account);
        }
        return null; // or throw an exception
    }

    // Method to delete an account by ID
    public void deleteAccount(int accountId) {
        accountRepository.deleteById(accountId);
    }


}

