package com.sicpp.infrastructure.config;

import com.sicpp.application.gateway.CreateUserGateway;
import com.sicpp.application.usecaseimpl.user.CreateUserUseCaseImpl;
import com.sicpp.usecase.user.CreateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public CreateUserUseCase createUserUseCase(CreateUserGateway createUserGateway){
        return new CreateUserUseCaseImpl(createUserGateway);
    }
}
