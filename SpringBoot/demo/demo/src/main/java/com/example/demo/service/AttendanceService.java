
package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.mapstruct.AttendanceMapper;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class AttendanceService {

    private final AttendanceRepository repo;
    private final StudentRepository srepo;
    private final AttendanceMapper mapper;

    public AttendanceService(AttendanceRepository repo,
                             StudentRepository srepo,
                             AttendanceMapper mapper) {
        this.repo = repo;
        this.srepo = srepo;
        this.mapper = mapper;
    }

    public AttendanceDTO addAttendance(Long studentId, AttendanceDTO dto) {

        StudentEntity student = srepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        AttendanceEntity attendance = mapper.toEntity(dto);
        attendance.setStudent(student);

        return mapper.toDTO(repo.save(attendance));
    }

    @Transactional(readOnly = true)
    public List<AttendanceDTO> getStudentAttendance(Long studentId) {
        if (!srepo.existsById(studentId)) {
            throw new RuntimeException("Student not found");
        }

        return repo.findByStudentId(studentId)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<AttendanceDTO> getAllAttendance() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}