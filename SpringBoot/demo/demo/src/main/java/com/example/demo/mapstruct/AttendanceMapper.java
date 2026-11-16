package com.example.demo.mapstruct;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.entity.AttendanceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    @Mapping(source = "student.id", target = "studentId")
    AttendanceDTO toDTO(AttendanceEntity attendance);

    @Mapping(target = "student", ignore = true)
    AttendanceEntity toEntity(AttendanceDTO dto);
}