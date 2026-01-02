package com.sicpp.infrastructure.service;

import com.sicpp.application.gateway.EncodePasswordGateway;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncodePasswordGatewayImpl implements EncodePasswordGateway {

    private final PasswordEncoder passwordEncoder;

    public EncodePasswordGatewayImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
