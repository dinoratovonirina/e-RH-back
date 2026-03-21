package com.example.e_RH.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.e_RH.auth.dto.AuthResponse;
import com.example.e_RH.auth.dto.LoginRequest;
import com.example.e_RH.config.security.JwtUtils;
import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.departement.service.DepartementService;
import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.service.RoleService;
import com.example.e_RH.users.entity.User;
import com.example.e_RH.users.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;
    private final DepartementService departementService;

    public User register(User request) {
        Role role = checkRole(request.getRole());
        Departement departement = checkDepartement(request.getDepartement());
        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .departement(departement)
                .isActive(request.getIsActive() != null ? request.getIsActive() : false)
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();

        return userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        String token = jwtUtils.generateToken(user.getEmail());

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    private Role checkRole(Role role) {
        Long roleId = role.getId();
        Role checkRole = this.roleService.getRoleById(roleId);
        if (checkRole == null || roleId == null) throw new RuntimeException("Role not found");
        
        return checkRole;
    }

    private Departement checkDepartement(Departement departement) {
        Long departementId = departement.getId();
        Departement checkDepart = this.departementService.getDepartementById(departementId);
        if (checkDepart == null || departementId == null) throw new RuntimeException("Departement not found");

        return checkDepart;
    }
}