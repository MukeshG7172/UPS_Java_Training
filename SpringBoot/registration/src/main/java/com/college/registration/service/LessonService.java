package com.college.registration.service;

import com.college.registration.dto.LessonRequestDTO;
import com.college.registration.dto.LessonResponseDTO;
import com.college.registration.entity.Course;
import com.college.registration.entity.Lesson;
import com.college.registration.repository.CourseRepository;
import com.college.registration.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseRepository courseRepository;

    public LessonResponseDTO createLesson(LessonRequestDTO dto) {
        Course course = courseRepository.findById(dto.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.courseId()));

        Lesson lesson = new Lesson();
        lesson.setLessonName(dto.lessonName());
        lesson.setDescription(dto.description());
        lesson.setCourse(course);

        Lesson savedLesson = lessonRepository.save(lesson);
        return mapToResponseDTO(savedLesson);
    }

    public List<LessonResponseDTO> getAllLessons() {
        return lessonRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public LessonResponseDTO getLessonById(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));
        return mapToResponseDTO(lesson);
    }

    public LessonResponseDTO updateLesson(Long id, LessonRequestDTO dto) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));

        lesson.setLessonName(dto.lessonName());
        lesson.setDescription(dto.description());

        if (dto.courseId() != null) {
            Course course = courseRepository.findById(dto.courseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.courseId()));
            lesson.setCourse(course);
        }

        Lesson updatedLesson = lessonRepository.save(lesson);
        return mapToResponseDTO(updatedLesson);
    }

    public void deleteLesson(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));
        lessonRepository.delete(lesson);
    }

    public List<LessonResponseDTO> getLessonsByCourseId(Long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("Course not found with id: " + courseId);
        }

        return lessonRepository.findByCourseId(courseId).stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    private LessonResponseDTO mapToResponseDTO(Lesson lesson) {
        return new LessonResponseDTO(
                lesson.getId(),
                lesson.getLessonName(),
                lesson.getDescription(),
                lesson.getCourse() != null ? lesson.getCourse().getId() : null,
                lesson.getCourse() != null ? lesson.getCourse().getCourseName() : null
        );
    }
}

