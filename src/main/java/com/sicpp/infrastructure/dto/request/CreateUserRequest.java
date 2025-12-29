package com.sicpp.infrastructure.dto.request;

import com.sicpp.core.domain.enums.UserTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(

        @Schema(description = "E-mail do usuário")
        @NotBlank String email,

        @Schema(description = "Senha do usuário")
        @NotBlank String password,

        @Schema(description = "Nome completo do usuário")
        @NotBlank String fullname,

        @Schema(description = "Tipo do usuário")
        @NotNull UserTypeEnum type
) {}
