package com.mubeendev3.OnlineBankingSystem.dto;

import com.mubeendev3.OnlineBankingSystem.entities.Account;

import java.math.BigDecimal;

public class AccountCreationDto {
    private BigDecimal balance;
    private Account.AccountType accountType;
    private int userId;


    public AccountCreationDto(BigDecimal balance, Account.AccountType accountType, int userId) {
        this.balance = balance;
        this.accountType = accountType;
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Account.AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(Account.AccountType accountType) {
        this.accountType = accountType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
