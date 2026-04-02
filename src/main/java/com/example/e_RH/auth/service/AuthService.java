package com.example.e_RH.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.e_RH.auth.dto.AuthResponse;
import com.example.e_RH.auth.dto.LoginRequest;
import com.example.e_RH.config.security.JwtUtils;
import com.example.e_RH.user.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
        private final JwtUtils jwtUtils;
        private final AuthenticationManager authenticationManager;

        public AuthResponse login(LoginRequest request) {
                var authentication = authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.email(), request.password()));

                User user = (User) authentication.getPrincipal();

                String token = jwtUtils.generateToken(user.getEmail());

                return AuthResponse.builder()
                                .token(token)
                                .build();
        }
}