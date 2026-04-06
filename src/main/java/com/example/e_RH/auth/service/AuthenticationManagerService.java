package com.example.e_RH.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.e_RH.auth.dto.LoginRequest;
import com.example.e_RH.auth.service.impl.IAuthenticationContext;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthenticationManagerService implements IAuthenticationContext {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication authenticate(LoginRequest request) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password()));
    }
}
