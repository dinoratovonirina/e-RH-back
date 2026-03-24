package com.example.e_RH.role.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleRepository roleRepository;

    @GetMapping("list")
    public ResponseEntity<List<Role>> getAllRole() {
        return ResponseEntity.status(HttpStatus.OK).body(roleRepository.findAll());
    }
}
