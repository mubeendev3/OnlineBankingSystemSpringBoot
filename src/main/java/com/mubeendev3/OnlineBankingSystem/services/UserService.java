package com.mubeendev3.OnlineBankingSystem.services;


import com.mubeendev3.OnlineBankingSystem.entities.User;
import com.mubeendev3.OnlineBankingSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; // or throw an exception
    }

    public long countUserAccounts(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && user.getAccounts() != null) {
            System.out.println(user.getAccounts());
            return user.getAccounts().size(); // Returns the number of accounts
        }
        return 0; // User not found or no accounts
    }


}
