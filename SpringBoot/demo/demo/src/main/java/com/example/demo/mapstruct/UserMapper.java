package com.example.demo.mapstruct;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDTO toDTO(UserEntity ue);
    UserEntity toEntity(UserDTO ud);
}