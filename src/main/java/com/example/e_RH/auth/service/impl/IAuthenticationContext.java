package com.example.e_RH.auth.service.impl;


import org.springframework.security.core.Authentication;

import com.example.e_RH.auth.dto.LoginRequest;

public interface IAuthenticationContext {
    Authentication authenticate(LoginRequest request);
}
