package com.sicpp.infrastructure.repository;

import com.sicpp.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
    Boolean existsByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
}
