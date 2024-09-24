package com.mubeendev3.OnlineBankingSystem.repositories;

import com.mubeendev3.OnlineBankingSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
