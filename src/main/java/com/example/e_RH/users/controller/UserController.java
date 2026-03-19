package com.example.e_RH.users.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_RH.users.entity.User;
import com.example.e_RH.users.repository.UserRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("list")
    public List<User> getListUsers() {
        return this.userRepository.findAll();
    }
}
