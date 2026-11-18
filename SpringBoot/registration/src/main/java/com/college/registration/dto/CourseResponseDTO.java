package com.college.registration.dto;

public record CourseResponseDTO(
        Long id,
        String courseName,
        String duration,
        Double fee,
        Long userId,
        String userName
) {}

