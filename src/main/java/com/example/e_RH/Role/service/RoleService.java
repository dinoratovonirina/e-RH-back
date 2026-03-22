package com.example.e_RH.role.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Optional<Role> getRoleById(Long roleId) {
        return this.roleRepository.findRoleById(roleId);
    }
}
