package com.sicpp.application.gateway;

import com.sicpp.application.gateway.dto.SessionWithUser;
import com.sicpp.core.domain.Session;

import java.util.Optional;

public interface FindSessionByRefreshTokenGateway {

    SessionWithUser findByRefreshToken(String refreshToken);
}
