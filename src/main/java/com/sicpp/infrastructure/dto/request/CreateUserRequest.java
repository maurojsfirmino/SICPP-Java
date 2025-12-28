package com.sicpp.infrastructure.dto.request;

import com.sicpp.core.domain.enums.UserTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(

        @NotBlank String email,
        @NotBlank String password,
        @NotBlank String fullname,
        @NotNull UserTypeEnum type
) {}
