package com.sicpp.infrastructure.service;

import com.sicpp.application.gateway.CreateUserGateway;
import com.sicpp.core.domain.User;
import com.sicpp.infrastructure.mapper.UserMapper;
import com.sicpp.infrastructure.repository.UserEntityRepository;

import org.springframework.stereotype.Service;

import static com.sicpp.infrastructure.utils.Utilities.log;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {

    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Boolean create(User user) {
        try {
            log.info("Inicio da criação do usuário::CreateUserGatewayImpl");
            var userSaved = userEntityRepository.save(userMapper.toUserEntity(user));
            log.info("Usuário criado com sucesso::CreateUserGatewayImpl");
            return true;
        } catch (Exception e) {
            log.error("Houve um erro na criação do usuário::CreateUserGatewayImpl");
            return false;
        }
    }
}
