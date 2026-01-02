package com.sicpp.infrastructure.repository;

import com.sicpp.infrastructure.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface SessionEntityRepository extends JpaRepository<SessionEntity, UUID> {
    Optional<SessionEntity> findByRefreshToken(String refreshToken);

    @Modifying
    @Query("delete from SessionEntity s where s.refreshToken = :refreshToken")
    void deleteByRefreshToken(String refreshToken);
}
