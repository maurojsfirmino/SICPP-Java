package com.sicpp.application.gateway;

import com.sicpp.core.domain.User;

import java.util.Optional;

public interface AuthenticateUserGateway {

    Optional<User> findByEmail(String email);
}
