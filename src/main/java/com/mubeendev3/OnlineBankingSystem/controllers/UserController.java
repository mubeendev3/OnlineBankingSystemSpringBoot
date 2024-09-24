package com.mubeendev3.OnlineBankingSystem.controllers;

import com.mubeendev3.OnlineBankingSystem.entities.User;
import com.mubeendev3.OnlineBankingSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestParam String username, @RequestParam String password) {
        return userService.authenticateUser(username, password);
    }

    // New endpoint to get the number of accounts for a user
    @GetMapping("/{userId}/accounts/count")
    public long getUserAccountCount(@PathVariable int userId) {
        return userService.countUserAccounts(userId);
    }
}
