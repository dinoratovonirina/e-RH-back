package com.example.e_RH.auth.dto;

import lombok.Builder;

@Builder
public record LoginRequest(
        String email,
        String password) {
}
