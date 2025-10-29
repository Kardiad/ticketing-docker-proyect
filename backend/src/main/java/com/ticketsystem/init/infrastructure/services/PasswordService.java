package com.ticketsystem.init.infrastructure.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ticketsystem.init.domain.services.PasswordServiceInterface;

@Service
public class PasswordService implements PasswordServiceInterface {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String hashing(String rawPassword) {
        return this.passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean verifyPassword(String rawPassword, String hashedPassword) {
        return this.passwordEncoder.matches(rawPassword, hashedPassword);
    }
    
}
