package com.college.registration.service;

import com.college.registration.dto.CourseResponseDTO;
import com.college.registration.dto.LoginDTO;
import com.college.registration.dto.LoginResponseDTO;
import com.college.registration.dto.RegisterDTO;
import com.college.registration.dto.UserResponseDTO;
import com.college.registration.entity.User;
import com.college.registration.repository.CourseRepository;
import com.college.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AuthService authService;

    public UserResponseDTO registerUser(RegisterDTO dto) {
        return authService.register(dto);
    }

    public LoginResponseDTO loginUser(LoginDTO dto) {
        return authService.login(dto);
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToUserResponseDTO)
                .toList();
    }

    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return mapToUserResponseDTO(user);
    }

    public UserResponseDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return mapToUserResponseDTO(user);
    }

    public List<UserResponseDTO> getAllStudents() {
        return userRepository.findByRole("student").stream()
                .map(this::mapToUserResponseDTO)
                .toList();
    }

    public List<CourseResponseDTO> getCoursesByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        return courseRepository.findByUserId(userId).stream()
                .map(course -> new CourseResponseDTO(
                        course.getId(),
                        course.getCourseName(),
                        course.getDuration(),
                        course.getFee(),
                        course.getUser() != null ? course.getUser().getId() : null,
                        course.getUser() != null ? course.getUser().getName() : null
                ))
                .toList();
    }

    private UserResponseDTO mapToUserResponseDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getRole());
    }
}
