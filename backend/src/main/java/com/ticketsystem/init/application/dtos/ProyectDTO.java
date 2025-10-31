package com.ticketsystem.init.application.dtos;

import java.time.LocalDateTime;

import com.ticketsystem.init.infrastructure.entities.Proyect;
import com.ticketsystem.init.infrastructure.entities.Statuses;
import com.ticketsystem.init.infrastructure.entities.User;

public class ProyectDTO {

    private Long id;
    private Long createdBy;
    private UserDTO createdByUser;
    private String name;
    private String description;
    private Long statusId;
    private StatusesDTO status;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    public ProyectDTO(){}

    public ProyectDTO(
        Long id,
        Long createdBy,
        UserDTO createdByUser,
        String name,
        String description,
        Long statusId,
        StatusesDTO status,
        LocalDateTime updatedAt,
        LocalDateTime createdAt
    ){
        this.id = id;
        this.createdBy = createdBy;
        this.createdByUser = createdByUser;
        this.name = name;
        this.description = description;
        this.statusId = statusId;
        this.status = status;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public UserDTO getCreatedByUser() {
        return this.createdByUser;
    }

    public void setCreatedByUser(UserDTO createdByUser) {
        this.createdByUser = createdByUser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStatusId() {
        return this.statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public StatusesDTO getStatus() {
        return this.status;
    }

    public void setStatus(StatusesDTO status) {
        this.status = status;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public ProyectDTO fromEntities(Proyect proyect, User user, Statuses status){
        
        return this;
    }

}
