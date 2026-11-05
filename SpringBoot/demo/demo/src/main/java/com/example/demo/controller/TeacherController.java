package com.example.demo.controller;

import com.example.demo.entity.TeacherEntity;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teacher")
    public TeacherEntity addTeacher(@RequestBody TeacherEntity t){
        return teacherService.addTeacher(t);
    }

    @GetMapping("/teacher")
    public List<TeacherEntity> getTeachers(){
        return teacherService.getTeachers();
    }
}
