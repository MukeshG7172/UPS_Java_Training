package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/home")
    public String fun(){
        return "Welcome Mukesh!";
    }

    @PostMapping("/student")
    public StudentEntity user(@RequestBody StudentEntity s){
        return studentService.addStudent(s);
    }

    @GetMapping("/student")
    public List<StudentEntity> getStudents(){
        return studentService.getStudents();
    }
}
