package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapstruct.UserMapper;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository repo;

    @Mock
    private UserMapper maps;

    @InjectMocks
    private UserService userService;

    private UserEntity userEntity;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        userEntity = new UserEntity(1L, "mukesh", "secret123", "mukesh@example.com");
        userDTO = new UserDTO(1L, "mukesh", "mukesh@example.com");
    }

    @Test
    void testRegisterUser_Success() {
        when(repo.existsByUsername("mukesh")).thenReturn(false);
        when(repo.existsByEmail("mukesh@example.com")).thenReturn(false);
        when(repo.save(any(UserEntity.class))).thenReturn(userEntity);
        when(maps.toDTO(userEntity)).thenReturn(userDTO);

        UserDTO result = userService.registerUser(userEntity);

        assertNotNull(result);
        assertEquals("mukesh", result.getUsername());
        verify(repo, times(1)).save(userEntity);
    }

    @Test
    void testRegisterUser_AlreadyExists_ThrowsException() {
        when(repo.existsByUsername("mukesh")).thenReturn(true);

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            userService.registerUser(userEntity);
        });

        assertTrue(ex.getMessage().contains("already exists with username: mukesh"));
        verify(repo, never()).save(any());
    }

    @Test
    void testLoginUser_Success() {
        when(repo.findByUsername("mukesh")).thenReturn(Optional.of(userEntity));
        when(maps.toDTO(userEntity)).thenReturn(userDTO);

        UserEntity loginRequest = new UserEntity();
        loginRequest.setUsername("mukesh");
        loginRequest.setPassword("secret123");

        UserDTO result = userService.loginUser(loginRequest);

        assertNotNull(result);
        assertEquals("mukesh", result.getUsername());
    }

    @Test
    void testLoginUser_UserNotFound_ThrowsException() {
        when(repo.findByUsername("unknown")).thenReturn(Optional.empty());

        UserEntity loginRequest = new UserEntity();
        loginRequest.setUsername("unknown");
        loginRequest.setPassword("secret123");

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            userService.loginUser(loginRequest);
        });

        assertTrue(ex.getMessage().contains("does not exist"));
    }

    @Test
    void testLoginUser_InvalidPassword_ThrowsException() {
        when(repo.findByUsername("mukesh")).thenReturn(Optional.of(userEntity));

        UserEntity loginRequest = new UserEntity();
        loginRequest.setUsername("mukesh");
        loginRequest.setPassword("wrongpassword");

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            userService.loginUser(loginRequest);
        });

        assertTrue(ex.getMessage().contains("Invalid password"));
    }

    @Test
    void testCheckUserExists() {
        when(repo.existsByUsername("mukesh")).thenReturn(true);
        when(repo.existsByUsername("nonexistent")).thenReturn(false);

        assertTrue(userService.checkUserExists("mukesh"));
        assertFalse(userService.checkUserExists("nonexistent"));
    }
}

