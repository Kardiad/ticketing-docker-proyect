package com.ticketsystem.init.infrastructure.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ticketsystem.init.application.dtos.UserDTO;
import com.ticketsystem.init.application.usecases.CreateUserUseCase;
import com.ticketsystem.init.application.usecases.LoginUserUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController()
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private CreateUserUseCase createUserUseCase;
    @Autowired
    private LoginUserUseCase loginUserUsecase;

    @PostMapping
    public ResponseEntity<?> postMethodName(@RequestBody UserDTO entity) {
        UserDTO user = createUserUseCase.execute(entity);
        if(user != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user data");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO entity) {
        UserDTO user = loginUserUsecase.execute(entity);
        if(user != null){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Credentials are invalid");
    }
    
    

}
