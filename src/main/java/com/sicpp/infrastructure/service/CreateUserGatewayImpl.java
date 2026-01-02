package com.sicpp.infrastructure.service;

import com.sicpp.application.gateway.CreateUserGateway;
import com.sicpp.application.gateway.EncodePasswordGateway;
import com.sicpp.core.domain.User;
import com.sicpp.infrastructure.mapper.UserMapper;
import com.sicpp.infrastructure.repository.UserEntityRepository;

import org.springframework.stereotype.Service;

import static com.sicpp.infrastructure.utils.Utilities.log;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {

    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;
    private final EncodePasswordGateway encodePasswordGateway;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper, EncodePasswordGateway encodePasswordGateway) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.encodePasswordGateway = encodePasswordGateway;
    }

    @Override
    public Boolean create(User user) {
        try {
            log.info("Inicio da criação do usuário::CreateUserGatewayImpl");
            String encodedPassword = encodePasswordGateway.encode(user.getPassword());
            user.setPassword(encodedPassword);
            var userSaved = userEntityRepository.save(userMapper.toUserEntity(user));
            log.info("Usuário criado com sucesso::CreateUserGatewayImpl");
            return true;
        } catch (Exception e) {
            log.error("Houve um erro na criação do usuário::CreateUserGatewayImpl");
            return false;
        }
    }
}
