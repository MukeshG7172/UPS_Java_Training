package com.example.demo.service;

import com.example.demo.entity.TeacherEntity;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repo;

    public TeacherEntity addTeacher(TeacherEntity t){
        return repo.save(t);
    }

    public List<TeacherEntity> getTeachers(){
        return repo.findAll();
    }
}
