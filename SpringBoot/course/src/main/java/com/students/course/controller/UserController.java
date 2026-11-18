
package com.students.course.controller;

import com.students.course.dto.RegisterDTO;
import com.students.course.entity.UserEntity;
import com.students.course.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService src;

    public UserController(UserService src) {
        this.src = src;
    }

    @PostMapping("/register")
    public RegisterDTO registerUser(@RequestBody RegisterDTO usr) {
        return src.registerUser(usr);
    }

    @PostMapping("/login")
    public RegisterDTO loginUser(@RequestBody UserEntity usr) {
        return src.login(usr);
    }
}
