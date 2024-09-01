package com.smartJobs.smart.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartJobs.smart.dto.User;
import com.smartJobs.smart.services.UserRepository;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class UserService {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) throws Exception {
        // Validate email format
        if (!Pattern.matches(EMAIL_REGEX, user.getEmail())) {
            throw new Exception("{\"mensaje\": \"Formato de correo inválido\"}");
        }

        // Validate password format
        if (!Pattern.matches(PASSWORD_REGEX, user.getPassword())) {
            throw new Exception("{\"mensaje\": \"Formato de contraseña inválido\"}");
        }

        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("{\"mensaje\": \"El correo ya registrado\"}");
        }

        user.setId(UUID.randomUUID());
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setToken(UUID.randomUUID().toString());
        user.setActive(true);

        return userRepository.save(user);
    }
}