package com.example.e_RH.auth.dto;

import lombok.Builder;

@Builder
public record RegisterRequest(
        String email,
        String password,
        String firstName,
        String lastName,
        Boolean isActive,
        Long roleId,
        Long departementId) {
}