package com.example.e_RH.users.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_RH.users.entity.User;
import com.example.e_RH.users.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("list")
    public ResponseEntity<List<User>> getListUsers() {
        List<User> listUser = this.userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(listUser);
    }
}
