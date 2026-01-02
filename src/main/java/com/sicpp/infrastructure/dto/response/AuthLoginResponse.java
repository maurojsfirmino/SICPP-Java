package com.sicpp.infrastructure.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record AuthLoginResponse(
    @Schema(description="JWT de acesso")
    String accessToken,
    @Schema(description="JWT de atualização")
    String refreshToken) {}