package com.college.registration.dto;

public record LoginResponseDTO(
        String message,
        Long id,
        String name,
        String email,
        String role
) {}

