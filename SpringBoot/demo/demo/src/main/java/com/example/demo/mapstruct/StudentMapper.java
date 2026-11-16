package com.example.demo.mapstruct;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDTO(StudentEntity se);
    StudentEntity toEntity(StudentDTO st);
}
