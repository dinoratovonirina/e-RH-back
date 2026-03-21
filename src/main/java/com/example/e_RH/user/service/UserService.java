package com.example.e_RH.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.departement.service.DepartementService;
import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.service.RoleService;
import com.example.e_RH.user.entity.User;
import com.example.e_RH.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final DepartementService departementService;

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
