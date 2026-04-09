package com.example.e_RH.user.factory;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.e_RH.auth.dto.RegisterRequest;
import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.role.entity.Role;
import com.example.e_RH.user.entity.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserFactory implements IUserFactory {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(RegisterRequest request, Role role, Departement departement) {
        return User.builder()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .isActive(request.isActive() != null ? request.isActive() : false)
                .password(passwordEncoder.encode(request.password()))
                .role(role)
                .departement(departement)
                .build();
    }
}
