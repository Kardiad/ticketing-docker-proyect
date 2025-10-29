package com.ticketsystem.init.infrastructure.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ticketsystem.init.infrastructure.services.JwtInternalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController("/auth")
public class AuthController {
    
    @Autowired
    private JwtInternalService jwtInternalService;

    @GetMapping("/get_token_test")
    public String getMethodName(@RequestParam String param) {
        return this.jwtInternalService.generateToken("testSubject", null);        
    }

}
