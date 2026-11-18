package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserDTO registerUser(@Valid @RequestBody UserEntity user) {
        return authService.registerUser(user);
    }

    @PostMapping("/login")
    public UserDTO loginUser(@Valid @RequestBody UserEntity user) {
        return authService.loginUser(user);
    }

    @GetMapping("/check-user/{username}")
    public Map<String, Object> checkUserExists(@Valid @PathVariable String username) {
        boolean exists = authService.checkUserExists(username);
        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("exists", exists);
        return response;
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/login")
    public void loginPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login.html");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

