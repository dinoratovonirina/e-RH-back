package com.example.e_RH.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.e_RH.user.entity.User;
import com.example.e_RH.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
