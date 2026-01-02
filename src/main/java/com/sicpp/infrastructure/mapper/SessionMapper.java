package com.sicpp.infrastructure.mapper;

import com.sicpp.core.domain.Session;
import com.sicpp.infrastructure.entity.SessionEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SessionMapper {

    public SessionEntity toEntity(Session session, UUID userId) {
        return new SessionEntity(
                userId,
                session.getAccessToken(),
                session.getRefreshToken(),
                session.getExpiresAt()
        );
    }

    public Session toDomain(SessionEntity entity) {
        return new Session(
                entity.getAccessToken(),
                entity.getRefreshToken(),
                entity.getExpiresAt()
        );
    }
}
