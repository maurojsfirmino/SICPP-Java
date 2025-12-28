package com.sicpp.usecase.user;

import com.sicpp.core.domain.User;

import java.util.Optional;

public interface FindUserByEmailUseCase {
    Optional<User> execute(String email);
}
