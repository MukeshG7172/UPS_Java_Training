package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.TeacherEntity;
import com.example.demo.mapstruct.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;

@Service
public class StudentService {
    @Autowired
    StudentMapper maps;

    @Autowired
    StudentRepository repo;

    @Autowired
    TeacherRepository trepo;

    public StudentDTO addStudent(Long id, StudentEntity s){
        TeacherEntity t = trepo.findById(id).orElseThrow(() -> new RuntimeException("Teacher not Found"));
        s.setTeacher(t);
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
        student.setTeacher(updatedStudent.getTeacher());

        StudentEntity st = repo.save(student);
        return maps.toDTO(st);
    }
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
