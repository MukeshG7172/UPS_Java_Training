package com.college.registration.dto;

public record ResponseDTO(
        Long id,
        String name,
        String email,
        String role
) {}