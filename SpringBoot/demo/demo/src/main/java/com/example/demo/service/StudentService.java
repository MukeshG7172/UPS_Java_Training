package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.mapstruct.StudentMapper;
import com.example.demo.repository.StudentRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentMapper maps;

    @Autowired
    StudentRepository repo;

    public StudentDTO addStudent(StudentEntity s){
        StudentEntity st = repo.save(s);
        return maps.toDTO(st);
    }

    public List<StudentDTO> getStudents(){
        return repo.findAll().stream().map(maps::toDTO).collect(Collectors.toList());
    }

    public StudentDTO updateStudent(Long id, StudentEntity updatedStudent) {
        StudentEntity student = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(updatedStudent.getName());
        student.setAge(updatedStudent.getAge());
        student.setMarks(updatedStudent.getMarks());

        StudentEntity st = repo.save(student);
        return maps.toDTO(st);
    }
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
