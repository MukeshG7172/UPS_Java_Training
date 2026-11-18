
package com.example.demo.dto;

import java.util.List;

public class StudentDTO {

    private Long id;
    private String name;
    private int age;
    private Long teacherId;
    private List<AttendanceDTO> attendanceRecords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public List<AttendanceDTO> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void setAttendanceRecords(List<AttendanceDTO> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }
}