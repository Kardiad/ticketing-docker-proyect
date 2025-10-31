package com.ticketsystem.init.application.dtos;

import com.ticketsystem.init.infrastructure.entities.Statuses;

public class StatusesDTO {
    
    private Long id;
    private String name;

    public StatusesDTO(Long id , String name){
        this.id = id;
        this.name = name;
    }

    public StatusesDTO(){

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusesDTO fromEntities(Statuses status){
        this.name = status.getName();
        this.id = status.getId();
        return this;
    }
    
}
