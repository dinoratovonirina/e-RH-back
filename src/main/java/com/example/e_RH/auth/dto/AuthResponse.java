package com.example.e_RH.auth.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthResponse {
    private String token;
}