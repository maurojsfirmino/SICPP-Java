package com.sicpp.infrastructure.service;

import com.sicpp.application.gateway.GenerateTokenGateway;

import com.sicpp.infrastructure.config.JwtProperties;
import com.sicpp.infrastructure.helper.GetSignKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GenerateTokenGatewayImpl implements GenerateTokenGateway {

    private final GetSignKey getSignKey;
    private final JwtProperties jwtProperties;

    public GenerateTokenGatewayImpl(GetSignKey getSignKey, JwtProperties jwtProperties) {
        this.getSignKey = getSignKey;
        this.jwtProperties = jwtProperties;
    }


    @Override
    public String generateAccessToken(String username) {
        return createToken(
                username,
                jwtProperties.getAccessTokenExpiration()
        );
    }

    @Override
    public String generateRefreshToken(String username) {
        return createToken(
                username,
                jwtProperties.getRefreshTokenExpiration()
        );
    }

    private String createToken(String subject, Long expiration) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignKey.get(), SignatureAlgorithm.HS256)
                .compact();
    }
}
