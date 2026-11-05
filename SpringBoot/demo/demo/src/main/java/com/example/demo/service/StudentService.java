package com.example.demo.service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    public StudentEntity addStudent(StudentEntity s){
        return repo.save(s);
    }

    public List<StudentEntity> getStudents(){
        return repo.findAll();
    }
}
