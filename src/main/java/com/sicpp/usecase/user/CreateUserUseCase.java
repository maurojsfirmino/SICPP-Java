package com.sicpp.usecase.user;

import com.sicpp.core.domain.User;
import com.sicpp.core.exception.EmailException;
import com.sicpp.core.exception.InternalServerErrorException;

public interface CreateUserUseCase {
    void create(User user) throws EmailException, InternalServerErrorException;
}
