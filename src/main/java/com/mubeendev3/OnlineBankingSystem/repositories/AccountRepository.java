package com.mubeendev3.OnlineBankingSystem.repositories;


import com.mubeendev3.OnlineBankingSystem.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    // Find all accounts for a specific user
    List<Account> findByUserUserId(int userId);

    // Optional: Find account by account type (CHECKING or SAVINGS)
    List<Account> findByAccountType(Account.AccountType accountType);
}
