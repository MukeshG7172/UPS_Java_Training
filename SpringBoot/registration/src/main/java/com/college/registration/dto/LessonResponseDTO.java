package com.college.registration.dto;

public record LessonResponseDTO(
        Long id,
        String lessonName,
        String description,
        Long courseId,
        String courseName
) {}

