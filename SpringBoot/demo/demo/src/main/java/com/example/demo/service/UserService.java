package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapstruct.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserMapper maps;

    @Autowired
    UserRepository repo;

    public boolean checkUserExists(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        return repo.existsByUsername(username.trim());
    }

    public boolean checkEmailExists(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return repo.existsByEmail(email.trim());
    }

    public UserDTO registerUser(UserEntity user) {
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new RuntimeException("Username cannot be empty");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Password cannot be empty");
        }

        String username = user.getUsername().trim();

        // Check if user already exists in the database
        if (repo.existsByUsername(username)) {
            throw new RuntimeException("User already exists with username: " + username);
        }

        if (user.getEmail() != null && !user.getEmail().trim().isEmpty()) {
            String email = user.getEmail().trim();
            if (repo.existsByEmail(email)) {
                throw new RuntimeException("User already exists with email: " + email);
            }
            user.setEmail(email);
        }

        user.setUsername(username);
        UserEntity saved = repo.save(user);
        return maps.toDTO(saved);
    }

    public UserDTO loginUser(UserEntity user) {
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new RuntimeException("Username cannot be empty");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Password cannot be empty");
        }

        String username = user.getUsername().trim();

        // Check if user exists in the database
        UserEntity existingUser = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User does not exist with username: " + username));

        // Validate password
        if (!existingUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return maps.toDTO(existingUser);
    }

    public List<UserDTO> getUsers() {
        return repo.findAll().stream().map(maps::toDTO).collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        UserEntity user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return maps.toDTO(user);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}

