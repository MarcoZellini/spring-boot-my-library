package com.example.MyLibraryBackendSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyLibraryBackendSpringBoot.model.User;
import com.example.MyLibraryBackendSpringBoot.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String email) {
        return userRepository.findByEmail(email);
    }

    public User register(User user) {
        return userRepository.save(user);
    }
}
