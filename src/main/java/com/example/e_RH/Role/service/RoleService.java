package com.example.e_RH.role.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.enums.RoleTypeEnum;
import com.example.e_RH.role.repository.RoleRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Optional<Role> getRoleByName(RoleTypeEnum roleName) {
        return this.roleRepository.findByRoleName(roleName);
    }

    public Optional<Role> getRoleById(@NonNull Long roleId) {
        return this.roleRepository.findById(roleId);
    }

    public List<Role> getAllRole() {
        return this.roleRepository.findAll();
    }
}
