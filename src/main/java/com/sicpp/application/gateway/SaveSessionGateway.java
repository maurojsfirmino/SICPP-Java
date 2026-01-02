package com.sicpp.application.gateway;

import com.sicpp.core.domain.Session;

import java.util.UUID;

public interface SaveSessionGateway {

    void save(Session session, UUID userId);
}
