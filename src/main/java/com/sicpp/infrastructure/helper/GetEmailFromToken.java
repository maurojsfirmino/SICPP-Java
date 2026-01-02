package com.sicpp.infrastructure.helper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class GetEmailFromToken {

    private final GetSignKey getSignKey;

    public GetEmailFromToken(GetSignKey getSignKey) {
        this.getSignKey = getSignKey;
    }

    public String get(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSignKey.get())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject(); // email
    }
}
