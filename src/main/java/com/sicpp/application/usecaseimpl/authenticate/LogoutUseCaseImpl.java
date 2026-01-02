package com.sicpp.application.usecaseimpl.authenticate;

import com.sicpp.application.gateway.DeleteSessionByRefreshTokenGateway;
import com.sicpp.usecase.authenticate.LogoutUseCase;
import com.sicpp.core.exception.UnauthorizedException;
import com.sicpp.infrastructure.dto.request.LogoutRequest;
import com.sicpp.infrastructure.dto.response.LogoutResponse;

public class LogoutUseCaseImpl implements LogoutUseCase {

    private final DeleteSessionByRefreshTokenGateway deleteSessionGateway;

    public LogoutUseCaseImpl(
            DeleteSessionByRefreshTokenGateway deleteSessionGateway
    ) {
        this.deleteSessionGateway = deleteSessionGateway;
    }

    @Override
    public LogoutResponse execute(LogoutRequest request) {

        if (request.refreshToken() == null || request.refreshToken().isBlank()) {
            throw new UnauthorizedException("Refresh token inválido");
        }

        deleteSessionGateway.deleteByRefreshToken(request.refreshToken());

        return new LogoutResponse("Logout realizado com sucesso");
    }
}
