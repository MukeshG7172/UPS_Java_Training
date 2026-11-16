package com.example.demo.mapstruct;

import com.example.demo.dto.TeacherDTO;
import com.example.demo.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDTO toDTO(TeacherEntity te);
    TeacherEntity toEntity(TeacherDTO td);
}
