package com.ticketsystem.init.domain.entities;

public class StatusesDAO {

    private Long id;
    private String name;

    public StatusesDAO(Long id , String name){
        this.id = id;
        this.name = name;
    }

    public StatusesDAO(String name){
        this.name = name;
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
}
