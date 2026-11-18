package com.students.course.mapper;

import com.students.course.dto.RegisterDTO;
import com.students.course.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegisterMapper {

    UserEntity toEntity(RegisterDTO dto);

    @Mapping(target = "password", ignore = true)
    RegisterDTO toDTO(UserEntity userEntity);
}