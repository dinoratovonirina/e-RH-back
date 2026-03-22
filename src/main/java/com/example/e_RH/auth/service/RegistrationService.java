package com.example.e_RH.auth.service;

import org.springframework.stereotype.Service;

import com.example.e_RH.auth.dto.RegisterRequest;
import com.example.e_RH.auth.factory.UserFactory;
import com.example.e_RH.user.entity.User;
import com.example.e_RH.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserFactory userFactory;
    private final UserRepository userRepository;

    public User register(RegisterRequest request) {
        return userRepository.save(this.userFactory.create(request));
    }
}
