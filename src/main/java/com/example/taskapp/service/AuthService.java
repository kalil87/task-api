package com.example.taskapp.service;

import com.example.taskapp.dto.request.LoginRequest;
import com.example.taskapp.entity.User;
import com.example.taskapp.exception.InvalidCredentialsException;
import com.example.taskapp.exception.UserNotFoundException;
import com.example.taskapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public String login(LoginRequest request) {

        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!user.getPassword().equals(request.password())) {
            throw new InvalidCredentialsException("Invalid password");
        }

        return jwtService.generateToken(user);
    }
}