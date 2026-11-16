package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/home")
    public String fun(){
        return "Welcome Mukesh!";
    }

    @PostMapping("/student/{id}")
    public StudentDTO user(@PathVariable Long id, @RequestBody StudentEntity s){
        return studentService.addStudent(id, s);
    }

    @GetMapping("/students")
    public List<StudentDTO> getStudents(){
        return studentService.getStudents();
    }

    @PutMapping("/student/{id}")
    public StudentDTO updateStudents(
            @PathVariable Long id,
            @RequestBody StudentEntity s) {

        return studentService.updateStudent(id, s);
    }

    @DeleteMapping("/student/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
