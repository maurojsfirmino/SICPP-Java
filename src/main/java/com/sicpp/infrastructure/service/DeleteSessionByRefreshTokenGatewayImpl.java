package com.sicpp.infrastructure.service;

import com.sicpp.application.gateway.DeleteSessionByRefreshTokenGateway;
import com.sicpp.infrastructure.repository.SessionEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteSessionByRefreshTokenGatewayImpl
        implements DeleteSessionByRefreshTokenGateway {

    private final SessionEntityRepository repository;

    public DeleteSessionByRefreshTokenGatewayImpl(
            SessionEntityRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void deleteByRefreshToken(String refreshToken) {
        repository.deleteByRefreshToken(refreshToken);
    }
}
