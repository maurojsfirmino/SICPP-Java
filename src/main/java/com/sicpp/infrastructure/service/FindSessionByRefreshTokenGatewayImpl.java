package com.sicpp.infrastructure.service;

import com.sicpp.application.gateway.FindSessionByRefreshTokenGateway;
import com.sicpp.application.gateway.dto.SessionWithUser;
import com.sicpp.core.domain.Session;
import com.sicpp.infrastructure.entity.SessionEntity;
import com.sicpp.infrastructure.mapper.SessionMapper;
import com.sicpp.infrastructure.repository.SessionEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class FindSessionByRefreshTokenGatewayImpl
        implements FindSessionByRefreshTokenGateway {

    private final SessionEntityRepository repository;
    private final SessionMapper mapper;

    public FindSessionByRefreshTokenGatewayImpl(
            SessionEntityRepository repository,
            SessionMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SessionWithUser findByRefreshToken(String refreshToken) {

        SessionEntity entity = repository.findByRefreshToken(refreshToken)
                .orElseThrow();

        Session session = mapper.toDomain(entity);

        return new SessionWithUser(session, entity.getUserId());
    }
}
