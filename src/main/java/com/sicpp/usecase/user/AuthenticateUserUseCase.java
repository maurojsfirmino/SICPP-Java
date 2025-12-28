package com.sicpp.usecase.user;

import com.sicpp.core.domain.User;

public interface AuthenticateUserUseCase {
    User authenticate(String email, String password);
}
