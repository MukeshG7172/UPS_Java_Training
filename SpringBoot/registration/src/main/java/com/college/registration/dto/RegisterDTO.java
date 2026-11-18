package com.college.registration.dto;

public record RegisterDTO(
        String name,
        String email,
        String password,
        String role
) {
    public RegisterDTO(String name, String email, String password) {
        this(name, email, password, "student");
    }
}
