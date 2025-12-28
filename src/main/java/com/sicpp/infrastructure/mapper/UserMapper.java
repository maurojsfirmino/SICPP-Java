package com.sicpp.infrastructure.mapper;

import com.sicpp.core.domain.User;
import com.sicpp.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

import com.sicpp.infrastructure.dto.request.CreateUserRequest;

@Component
public class UserMapper {

    public UserEntity toUserEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFullname(),
                user.getType(),
                user.getCreatedAt(),
                user.getUpdateAt()
        );
    }

    public User toUser(CreateUserRequest request) throws Exception {
        return new User(
                request.email(),
                request.password(),
                request.fullname(),
                request.type()
        );
    }

    public User toUser(UserEntity userEntity) throws Exception {
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getFulname(),
                userEntity.getType(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
    }

}
