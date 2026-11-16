package com.example.demo.controller;

import com.example.demo.dto.TeacherDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.TeacherEntity;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teacher")
    public TeacherDTO addTeacher(@RequestBody TeacherEntity t){
        return teacherService.addTeacher(t);
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> getTeachers(){
        return teacherService.getTeachers();
    }

    @PutMapping("/teacher/{id}")
    public TeacherDTO updateTeachers(
            @PathVariable Long id,
            @RequestBody TeacherEntity s) {

        return teacherService.updateTeacher(id, s);
    }

    @DeleteMapping("/teacher/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}
