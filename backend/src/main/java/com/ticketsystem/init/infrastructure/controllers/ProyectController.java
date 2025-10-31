package com.ticketsystem.init.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketsystem.init.application.dtos.ProyectDTO;
import com.ticketsystem.init.application.usecases.CreateProyectUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController()
@RequestMapping("/api/project")
public class ProyectController {
    
    @Autowired private CreateProyectUseCase createProyectUseCase;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody ProyectDTO entity) {
        ProyectDTO data = this.createProyectUseCase.execute(entity);
        if(data != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(data);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You need add name and user");
    }
    

}
