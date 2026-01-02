package com.sicpp.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sessions")
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false, length = 1000)
    private String accessToken;

    @Column(nullable = false, length = 1000)
    private String refreshToken;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    protected SessionEntity() {
    }

    public SessionEntity(
            UUID userId,
            String accessToken,
            String refreshToken,
            LocalDateTime expiresAt
    ) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresAt = expiresAt;
    }

    // getters

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
}
