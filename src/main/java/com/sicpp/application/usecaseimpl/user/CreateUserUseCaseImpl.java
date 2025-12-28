package com.sicpp.application.usecaseimpl.user;

import com.sicpp.application.gateway.CreateUserGateway;
import com.sicpp.core.domain.User;
import com.sicpp.core.exception.EmailException;
import com.sicpp.core.exception.InternalServerErrorException;
import com.sicpp.core.exception.enums.ErrorCodeEnum;
import com.sicpp.usecase.user.CreateUserUseCase;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    final private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(CreateUserGateway createUserGateway) {
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user) throws EmailException, InternalServerErrorException {
        if (!createUserGateway.create(user)) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}
