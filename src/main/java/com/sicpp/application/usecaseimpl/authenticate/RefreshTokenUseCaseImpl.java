package com.sicpp.application.usecaseimpl.authenticate;

import com.sicpp.application.gateway.FindSessionByRefreshTokenGateway;
import com.sicpp.application.gateway.GenerateTokenGateway;
import com.sicpp.application.gateway.SaveSessionGateway;
import com.sicpp.application.gateway.dto.SessionWithUser;
import com.sicpp.usecase.authenticate.RefreshTokenUseCase;
import com.sicpp.core.domain.Session;
import com.sicpp.core.exception.UnauthorizedException;
import com.sicpp.infrastructure.dto.request.RefreshTokenRequest;
import com.sicpp.infrastructure.dto.response.RefreshTokenResponse;

import java.time.LocalDateTime;

public class RefreshTokenUseCaseImpl implements RefreshTokenUseCase {

    private final FindSessionByRefreshTokenGateway findSessionGateway;
    private final GenerateTokenGateway generateTokenGateway;
    private final SaveSessionGateway saveSessionGateway;

    public RefreshTokenUseCaseImpl(
            FindSessionByRefreshTokenGateway findSessionGateway,
            GenerateTokenGateway generateTokenGateway,
            SaveSessionGateway saveSessionGateway
    ) {
        this.findSessionGateway = findSessionGateway;
        this.generateTokenGateway = generateTokenGateway;
        this.saveSessionGateway = saveSessionGateway;
    }

    @Override
    public RefreshTokenResponse execute(RefreshTokenRequest request) {

        SessionWithUser result =
                findSessionGateway.findByRefreshToken(request.refreshToken());

        Session session = result.session();

        if (session.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new UnauthorizedException("Refresh token expirado");
        }

        String newAccessToken =
                generateTokenGateway.generateAccessToken(session.getRefreshToken());

        Session updatedSession = new Session(
                newAccessToken,
                session.getRefreshToken(),
                session.getExpiresAt()
        );

        saveSessionGateway.save(updatedSession, result.userId());

        return new RefreshTokenResponse(newAccessToken);
    }
}
