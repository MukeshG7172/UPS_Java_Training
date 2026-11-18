package com.college.registration.dto;

public record CourseRequestDTO(
        String courseName,
        String duration,
        Double fee,
        Long userId
) {}

