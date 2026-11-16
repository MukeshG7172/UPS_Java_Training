
package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    @PostMapping("/students/{studentId}")
    public AttendanceDTO addAttendance(
            @PathVariable Long studentId,
            @RequestBody AttendanceDTO dto) {

        return service.addAttendance(studentId, dto);
    }

    @GetMapping("/students/{studentId}")
    public List<AttendanceDTO> getStudentAttendance(
            @PathVariable Long studentId) {

        return service.getStudentAttendance(studentId);
    }

    @GetMapping
    public List<AttendanceDTO> getAllAttendance() {
        return service.getAllAttendance();
    }
}