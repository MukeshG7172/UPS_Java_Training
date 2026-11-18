package com.college.registration.service;

import com.college.registration.dto.LoginDTO;
import com.college.registration.dto.LoginResponseDTO;
import com.college.registration.dto.RegisterDTO;
import com.college.registration.dto.UserResponseDTO;
import com.college.registration.entity.User;
import com.college.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO register(RegisterDTO dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email already registered!");
        }

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setRole(dto.role() != null && !dto.role().isBlank() ? dto.role() : "student");

        User savedUser = userRepository.save(user);
        return new UserResponseDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail(), savedUser.getRole());
    }

    public LoginResponseDTO login(LoginDTO dto) {
        User existingUser = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("User not found with email: " + dto.email()));

        if (!existingUser.getPassword().equals(dto.password())) {
            throw new RuntimeException("Invalid password!");
        }

        return new LoginResponseDTO("Login successful", existingUser.getId(), existingUser.getName(), existingUser.getEmail(), existingUser.getRole());
    }
}

