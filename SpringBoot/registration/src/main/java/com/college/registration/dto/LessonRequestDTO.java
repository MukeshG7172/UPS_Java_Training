package com.college.registration.dto;

public record LessonRequestDTO(
        String lessonName,
        String description,
        Long courseId
) {}

