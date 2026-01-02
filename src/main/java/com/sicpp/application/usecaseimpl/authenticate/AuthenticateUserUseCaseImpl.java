package com.sicpp.application.usecaseimpl.authenticate;

import com.sicpp.application.gateway.AuthenticateUserGateway;
import com.sicpp.application.gateway.EncodePasswordGateway;
import com.sicpp.application.gateway.GenerateTokenGateway;
import com.sicpp.application.gateway.SaveSessionGateway;
import com.sicpp.core.domain.Session;
import com.sicpp.core.domain.User;
import com.sicpp.core.exception.UnauthorizedException;
import com.sicpp.usecase.authenticate.AuthenticateUserUseCase;
import com.sicpp.infrastructure.dto.request.AuthenticateUserRequest;
import com.sicpp.infrastructure.dto.response.AuthenticateUserResponse;

import java.time.LocalDateTime;

public class AuthenticateUserUseCaseImpl implements AuthenticateUserUseCase {

    private final AuthenticateUserGateway authenticateUserGateway;
    private final EncodePasswordGateway encodePasswordGateway;
    private final GenerateTokenGateway generateTokenGateway;
    private final SaveSessionGateway saveSessionGateway;

    public AuthenticateUserUseCaseImpl(
            AuthenticateUserGateway authenticateUserGateway,
            EncodePasswordGateway encodePasswordGateway,
            GenerateTokenGateway generateTokenGateway,
            SaveSessionGateway saveSessionGateway
    ) {
        this.authenticateUserGateway = authenticateUserGateway;
        this.encodePasswordGateway = encodePasswordGateway;
        this.generateTokenGateway = generateTokenGateway;
        this.saveSessionGateway = saveSessionGateway;
    }

    @Override
    public AuthenticateUserResponse execute(AuthenticateUserRequest request) {

        User user = authenticateUserGateway
                .findByEmail(request.email())
                .orElseThrow(() ->
                        new UnauthorizedException("Credenciais inválidas")
                );

        boolean passwordValid = encodePasswordGateway.matches(
                request.password(),
                user.getPassword()
        );

        if (!passwordValid) {
            throw new UnauthorizedException("Credenciais inválidas");
        }

        String accessToken = generateTokenGateway.generateAccessToken(user.getEmail());
        String refreshToken = generateTokenGateway.generateRefreshToken(user.getEmail());

        Session session = new Session(
                accessToken,
                refreshToken,
                LocalDateTime.now().plusDays(1)
        );

        saveSessionGateway.save(session, user.getId());

        return new AuthenticateUserResponse(
                accessToken,
                refreshToken
        );
    }
}
