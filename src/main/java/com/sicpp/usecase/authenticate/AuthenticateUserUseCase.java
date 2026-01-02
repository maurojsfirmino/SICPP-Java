package com.sicpp.usecase.authenticate;

import com.sicpp.core.domain.Session;
import com.sicpp.infrastructure.dto.request.AuthenticateUserRequest;
import com.sicpp.infrastructure.dto.response.AuthenticateUserResponse;

public interface AuthenticateUserUseCase {
    AuthenticateUserResponse execute(AuthenticateUserRequest request);
}
