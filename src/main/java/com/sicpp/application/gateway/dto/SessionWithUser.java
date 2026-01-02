package com.sicpp.application.gateway.dto;

import com.sicpp.core.domain.Session;

import java.util.UUID;

public record SessionWithUser(
        Session session,
        UUID userId
) {}
