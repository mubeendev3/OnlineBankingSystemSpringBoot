package com.mubeendev3.OnlineBankingSystem.repositories;

import com.mubeendev3.OnlineBankingSystem.entities.Account;
import com.mubeendev3.OnlineBankingSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

}
