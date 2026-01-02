package com.sicpp.infrastructure.service;

import com.sicpp.application.gateway.SaveSessionGateway;
import com.sicpp.core.domain.Session;
import com.sicpp.infrastructure.mapper.SessionMapper;
import com.sicpp.infrastructure.repository.SessionEntityRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SaveSessionGatewayImpl implements SaveSessionGateway {

    private final SessionEntityRepository sessionRepository;
    private final SessionMapper sessionMapper;

    public SaveSessionGatewayImpl(
            SessionEntityRepository sessionRepository,
            SessionMapper sessionMapper
    ) {
        this.sessionRepository = sessionRepository;
        this.sessionMapper = sessionMapper;
    }

    @Override
    public void save(Session session, UUID userId) {
        sessionRepository.save(
                sessionMapper.toEntity(session, userId)
        );
    }
}
