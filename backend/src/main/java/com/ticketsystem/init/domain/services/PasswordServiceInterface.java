package com.ticketsystem.init.domain.services;

public interface PasswordServiceInterface {
    public String hashing(String rawPassword);
    public boolean verifyPassword(String rawPassword, String hashedPassword);    
}
