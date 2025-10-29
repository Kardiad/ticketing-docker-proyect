package com.ticketsystem.init.infrastructure.services;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtInternalService {
    private final Key internalToken;
    private final long expirationTime;

    public JwtInternalService(
        @Value("${token.internal}") String internalToken, 
        @Value("${token.expiration}") long expirationTime) {
        this.internalToken = Keys.hmacShaKeyFor(internalToken.getBytes()); 
        this.expirationTime = expirationTime * 1000;
    }

     public String generateToken(String subject, Map<String, Object> claims) {
        return Jwts.builder()
                .setSubject(subject)
                .addClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(internalToken, SignatureAlgorithm.HS256)
                .compact();
    }
    public Jws<Claims> validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(internalToken)
                .build()
                .parseClaimsJws(token);
    }
}
