package com.example.e_RH.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(
    int status,
    String message
) {}
