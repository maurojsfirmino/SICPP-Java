package com.sicpp.infrastructure.dto.request;

import com.sicpp.core.domain.enums.UserTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(

        @Schema(
                description = "E-mail do usuário",
                example = "user@email.com"
        )
        @NotBlank String email,

        @Schema(
                description = "Senha do usuário",
                example = "123456"
        )
        @NotBlank String password,

        @Schema(
                description = "Nome completo do usuário",
                example = "Mauro Firmino"
        )
        @NotBlank String fullname,

        @Schema(
                description = "Tipo do usuário",
                example = "USER"
        )
        @NotNull UserTypeEnum type
) {}
