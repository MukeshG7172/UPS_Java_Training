package com.students.course.service;

import com.students.course.dto.RegisterDTO;
import com.students.course.entity.UserEntity;
import com.students.course.mapper.RegisterMapper;
import com.students.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private RegisterMapper mapper;

    public RegisterDTO registerUser(RegisterDTO dto) {

        if (repo.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        if (dto.getName() == null) {
            throw new RuntimeException("Name cannot be empty");
        }

        if (dto.getEmail() == null) {
            throw new RuntimeException("Email cannot be empty");
        }

        UserEntity user = mapper.toEntity(dto);

        UserEntity savedUser = repo.save(user);

        return mapper.toDTO(savedUser);
    }

    public RegisterDTO login(UserEntity usr) {
        if(!repo.existsByEmail(usr.getEmail())) {
            throw new RuntimeException("User not found");
        }
        UserEntity cur = repo.findByEmail(usr.getEmail());
        if(!cur.getPassword().equals(usr.getPassword())){
            throw new RuntimeException("Incorrect Password");
        }
        System.out.println("Logged In Successfully");
        usr.setName(cur.getName());
        return mapper.toDTO(usr);
    }
}