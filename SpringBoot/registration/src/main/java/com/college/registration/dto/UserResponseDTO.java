package com.college.registration.dto;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String role
) {}

