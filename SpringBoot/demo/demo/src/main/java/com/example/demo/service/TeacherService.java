package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TeacherDTO;
import com.example.demo.entity.TeacherEntity;
import com.example.demo.mapstruct.TeacherMapper;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherService {
    @Autowired
    TeacherMapper maps;

    @Autowired
    TeacherRepository repo;

    public TeacherDTO addTeacher(TeacherEntity t){
        TeacherEntity teacher = repo.save(t);
        return maps.toDTO(teacher);
    }

    public List<TeacherDTO> getTeachers(){
        return repo.findAll().stream().map(maps::toDTO).collect(Collectors.toList());
    }

    public TeacherDTO updateTeacher(Long id, TeacherEntity updatedTeacher) {
        TeacherEntity t = repo.findById(id).orElseThrow(() -> new RuntimeException("Teacher not Found!"));

        t.setName(updatedTeacher.getName());
        t.setSubject(updatedTeacher.getSubject());
        t.setSalary(updatedTeacher.getSalary());
        t.setStudents(updatedTeacher.getStudents());

        TeacherEntity teacher = repo.save(t);
        return maps.toDTO(teacher);
    }

    public void deleteTeacher(Long id) {
        repo.deleteById(id);
    }
}
