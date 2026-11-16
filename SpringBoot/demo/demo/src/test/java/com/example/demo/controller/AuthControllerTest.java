package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Mock
    private AuthService authService;

    @Mock
    private UserService userService;

    @InjectMocks
    private AuthController authController;

    private UserEntity userEntity;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        userEntity = new UserEntity(1L, "mukesh", "pass123", "mukesh@example.com");
        userDTO = new UserDTO(1L, "mukesh", "mukesh@example.com");
    }

    @Test
    void testRegisterUser_Success() {
        when(authService.registerUser(any(UserEntity.class))).thenReturn(userDTO);

        UserDTO response = authController.registerUser(userEntity);

        assertNotNull(response);
        assertEquals("mukesh", response.getUsername());
        verify(authService, times(1)).registerUser(userEntity);
    }

    @Test
    void testLoginUser_Success() {
        when(authService.loginUser(any(UserEntity.class))).thenReturn(userDTO);

        UserDTO response = authController.loginUser(userEntity);

        assertNotNull(response);
        assertEquals("mukesh", response.getUsername());
        verify(authService, times(1)).loginUser(userEntity);
    }

    @Test
    void testCheckUserExists() {
        when(authService.checkUserExists("mukesh")).thenReturn(true);

        Map<String, Object> result = authController.checkUserExists("mukesh");

        assertEquals("mukesh", result.get("username"));
        assertEquals(true, result.get("exists"));
    }

    @Test
    void testHandleRuntimeException() {
        RuntimeException ex = new RuntimeException("User already exists with username: mukesh");
        ResponseEntity<Map<String, String>> response = authController.handleRuntimeException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("User already exists with username: mukesh", response.getBody().get("message"));
    }
}

