package com.ticketsystem.init.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketsystem.init.application.dtos.SprintDTO;
import com.ticketsystem.init.application.usecases.CreateSprintUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController()
@RequestMapping("/api/sprint")
public class SprintController {

    @Autowired
    CreateSprintUseCase createSprintUseCase;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody SprintDTO entity) {
        SprintDTO sprint = createSprintUseCase.execute(entity);
        if(sprint != null){
            return ResponseEntity.status(HttpStatus.OK).body(entity);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You need add name, proyectId, statusIds");
        
    }
    
    
}
