package com.sicpp.infrastructure.config;

import com.sicpp.application.gateway.*;
import com.sicpp.application.usecaseimpl.authenticate.AuthenticateUserUseCaseImpl;
import com.sicpp.application.usecaseimpl.authenticate.LogoutUseCaseImpl;
import com.sicpp.application.usecaseimpl.authenticate.RefreshTokenUseCaseImpl;
import com.sicpp.usecase.authenticate.AuthenticateUserUseCase;
import com.sicpp.usecase.authenticate.LogoutUseCase;
import com.sicpp.usecase.authenticate.RefreshTokenUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {

    @Bean
    public AuthenticateUserUseCase authenticateUserUseCase(
            AuthenticateUserGateway authenticateUserGateway,
            EncodePasswordGateway encodePasswordGateway,
            GenerateTokenGateway generateTokenGateway,
            SaveSessionGateway saveSessionGateway
    ) {
        return new AuthenticateUserUseCaseImpl(
                authenticateUserGateway,
                encodePasswordGateway,
                generateTokenGateway,
                saveSessionGateway
        );
    }

    @Bean
    public RefreshTokenUseCase refreshTokenUseCase(
            FindSessionByRefreshTokenGateway findSessionGateway,
            GenerateTokenGateway generateTokenGateway,
            SaveSessionGateway saveSessionGateway
    ) {
        return new RefreshTokenUseCaseImpl(
                findSessionGateway,
                generateTokenGateway,
                saveSessionGateway
        );
    }

    @Bean
    public LogoutUseCase logoutUseCase(
            DeleteSessionByRefreshTokenGateway deleteSessionGateway
    ) {
        return new LogoutUseCaseImpl(deleteSessionGateway);
    }
}

