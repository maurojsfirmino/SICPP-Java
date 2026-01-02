package com.sicpp.infrastructure.helper;

import com.sicpp.infrastructure.config.JwtProperties;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;

@Component
public class GetSignKey {

    private final JwtProperties jwtProperties;

    public GetSignKey(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public Key get() {
        return Keys.hmacShaKeyFor(
                jwtProperties.getSecret().getBytes(StandardCharsets.UTF_8)
        );
    }
}
