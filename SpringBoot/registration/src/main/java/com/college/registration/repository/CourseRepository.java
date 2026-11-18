package com.college.registration.repository;

import com.college.registration.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByUserId(Long userId);
    List<Course> findByCourseNameContainingIgnoreCase(String courseName);
}

