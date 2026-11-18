package com.college.registration.controller;

import com.college.registration.dto.LessonRequestDTO;
import com.college.registration.dto.LessonResponseDTO;
import com.college.registration.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lessons")
@CrossOrigin(origins = {"http://localhost:5173"})
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonResponseDTO> createLesson(@RequestBody LessonRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lessonService.createLesson(dto));
    }

    @GetMapping
    public List<LessonResponseDTO> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping("/{id}")
    public LessonResponseDTO getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    @PutMapping("/{id}")
    public LessonResponseDTO updateLesson(@PathVariable Long id, @RequestBody LessonRequestDTO dto) {
        return lessonService.updateLesson(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Lesson deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/course/{courseId}")
    public List<LessonResponseDTO> getLessonsByCourseId(@PathVariable Long courseId) {
        return lessonService.getLessonsByCourseId(courseId);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

