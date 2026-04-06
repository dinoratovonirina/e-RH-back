package com.example.e_RH.auth.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.e_RH.auth.dto.AuthResponse;
import com.example.e_RH.auth.dto.LoginRequest;
import com.example.e_RH.auth.service.impl.IAuthenticationContext;
import com.example.e_RH.config.security.JwtUtils;
import com.example.e_RH.user.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
        private final JwtUtils jwtUtils;
        private final IAuthenticationContext iAuthenticationContext;

        public AuthResponse login(LoginRequest request) {
                Authentication authentication = iAuthenticationContext.authenticate(
                                request);

                User user = (User) authentication.getPrincipal();

                String token = jwtUtils.generateToken(user.getEmail());

                return AuthResponse.builder()
                                .token(token)
                                .build();
        }
}