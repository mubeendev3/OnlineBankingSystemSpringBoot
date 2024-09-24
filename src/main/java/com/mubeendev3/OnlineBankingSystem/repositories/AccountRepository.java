package com.mubeendev3.OnlineBankingSystem.repositories;


import com.mubeendev3.OnlineBankingSystem.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    // Find all accounts for a specific user
    List<Account> findByUserUserId(int userId);

//     Optional: Find account by account type (CHECKING or SAVINGS)
    @Query("SELECT a FROM Account a WHERE a.user.userId = :user_id")
    List<Account> getAccountByUser(@Param("user_id") int userId);
}
