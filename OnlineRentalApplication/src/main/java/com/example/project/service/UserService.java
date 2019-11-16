package com.example.project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.project.controller.dto.UserRegistrationDto;
import com.example.project.model.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
