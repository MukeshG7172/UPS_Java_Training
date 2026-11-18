package com.college.registration.service;

import com.college.registration.dto.CourseRequestDTO;
import com.college.registration.dto.CourseResponseDTO;
import com.college.registration.dto.LessonResponseDTO;
import com.college.registration.entity.Course;
import com.college.registration.entity.User;
import com.college.registration.repository.CourseRepository;
import com.college.registration.repository.LessonRepository;
import com.college.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LessonRepository lessonRepository;

    public CourseResponseDTO createCourse(CourseRequestDTO dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.userId()));

        Course course = new Course();
        course.setCourseName(dto.courseName());
        course.setDuration(dto.duration());
        course.setFee(dto.fee());
        course.setUser(user);

        Course savedCourse = courseRepository.save(course);
        return mapToResponseDTO(savedCourse);
    }

    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public CourseResponseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        return mapToResponseDTO(course);
    }

    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        course.setCourseName(dto.courseName());
        course.setDuration(dto.duration());
        course.setFee(dto.fee());

        if (dto.userId() != null) {
            User user = userRepository.findById(dto.userId())
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.userId()));
            course.setUser(user);
        }

        Course updatedCourse = courseRepository.save(course);
        return mapToResponseDTO(updatedCourse);
    }

    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        courseRepository.delete(course);
    }

    public List<CourseResponseDTO> searchCourses(String name) {
        return courseRepository.findByCourseNameContainingIgnoreCase(name).stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public List<LessonResponseDTO> getLessonsByCourseId(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));

        return lessonRepository.findByCourseId(courseId).stream()
                .map(lesson -> new LessonResponseDTO(
                        lesson.getId(),
                        lesson.getLessonName(),
                        lesson.getDescription(),
                        course.getId(),
                        course.getCourseName()
                ))
                .toList();
    }

    private CourseResponseDTO mapToResponseDTO(Course course) {
        return new CourseResponseDTO(
                course.getId(),
                course.getCourseName(),
                course.getDuration(),
                course.getFee(),
                course.getUser() != null ? course.getUser().getId() : null,
                course.getUser() != null ? course.getUser().getName() : null
        );
    }
}

