package com.sicpp.infrastructure.service;

import com.sicpp.application.gateway.AuthenticateUserGateway;
import com.sicpp.core.domain.User;
import com.sicpp.infrastructure.entity.UserEntity;
import com.sicpp.infrastructure.mapper.UserMapper;
import com.sicpp.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticateUserGatewayImpl implements AuthenticateUserGateway {

    private final UserEntityRepository userRepository;
    private final UserMapper userMapper;

    public AuthenticateUserGatewayImpl(
            UserEntityRepository userRepository,
            UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDomain);
    }

}
