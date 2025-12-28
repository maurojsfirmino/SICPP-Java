package com.sicpp.application.gateway;

import com.sicpp.core.domain.User;

public interface CreateUserGateway {
    Boolean create(User user);
}
