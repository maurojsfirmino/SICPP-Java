package com.sicpp.application.gateway;

public interface EncodePasswordGateway {
    String encode(String rawPassword);
    boolean matches(String rawPassword, String encodedPassword);
}
