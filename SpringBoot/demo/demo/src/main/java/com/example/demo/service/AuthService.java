package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public UserDTO registerUser(UserEntity user) {
        return userService.registerUser(user);
    }

    public UserDTO loginUser(UserEntity user) {
        return userService.loginUser(user);
    }

    public boolean checkUserExists(String username) {
        return userService.checkUserExists(username);
    }
}

