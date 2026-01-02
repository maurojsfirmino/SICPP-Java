package com.sicpp.infrastructure.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record AuthenticateUserRequest(
    @Schema(description="admin@sicpp.com")
    @NotBlank String email,
    @Schema(description="123456")
    @NotBlank String password) {}
