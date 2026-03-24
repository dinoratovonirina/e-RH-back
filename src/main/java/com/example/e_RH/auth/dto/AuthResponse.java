package com.example.e_RH.auth.dto;

import lombok.Builder;

@Builder
public record AuthResponse(
        String token) {
}