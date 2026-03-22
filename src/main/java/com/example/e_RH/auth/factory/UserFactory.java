package com.example.e_RH.auth.factory;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.e_RH.auth.dto.RegisterRequest;
import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.departement.service.DepartementService;
import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.service.RoleService;
import com.example.e_RH.user.entity.User;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserFactory {
    private final RoleService roleService;
    private final DepartementService departementService;
    private final PasswordEncoder passwordEncoder;

    public User create(RegisterRequest  request) {
        Role role = roleService.getRoleById(request.getRoleId())
                                    .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        Departement departement = departementService.getDepartementById(request.getDepartementId())
                                    .orElseThrow(() -> new EntityNotFoundException("Departement not found"));
        return User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .departement(departement)
                .isActive(request.getIsActive() != null ? request.getIsActive() : false)
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();
    }
}
