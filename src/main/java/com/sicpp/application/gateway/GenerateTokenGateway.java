package com.sicpp.application.gateway;

import com.sicpp.core.domain.User;

public interface GenerateTokenGateway {

    String generateAccessToken(String email);
    String generateRefreshToken(String email);
}
