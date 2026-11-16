
package com.example.demo.mapstruct;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = AttendanceMapper.class)
public interface StudentMapper {

    @Mapping(source = "teacher.id", target = "teacherId")
    StudentDTO toDTO(StudentEntity se);

    @Mapping(target = "teacher", ignore = true)
    @Mapping(target = "attendanceRecords", ignore = true)
    StudentEntity toEntity(StudentDTO st);
}
