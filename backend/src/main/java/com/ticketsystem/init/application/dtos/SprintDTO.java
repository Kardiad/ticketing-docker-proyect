package com.ticketsystem.init.application.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ticketsystem.init.infrastructure.entities.Proyect;
import com.ticketsystem.init.infrastructure.entities.Sprint;
import com.ticketsystem.init.infrastructure.entities.Statuses;
import com.ticketsystem.init.infrastructure.entities.User;

public class SprintDTO {

    private Long id;
    private String name;
    private String description;
    private Long proyectId;
    private ProyectDTO proyect;
    private Long statusId;
    private StatusesDTO status;
    private LocalDate endDate;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    public SprintDTO(
            Long id,
            String name,
            String description,
            Long proyectId,
            ProyectDTO proyect,
            Long statusId,
            StatusesDTO status,
            LocalDate endDate,
            LocalDateTime updatedAt,
            LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.proyectId = proyectId;
        this.proyect = proyect;
        this.statusId = statusId;
        this.status = status;
        this.endDate = endDate;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public SprintDTO(){}

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getProyectId() {
        return this.proyectId;
    }

    public void setProyectId(Long proyectId) {
        this.proyectId = proyectId;
    }

    public ProyectDTO getProyect() {
        return this.proyect;
    }

    public void setProyect(ProyectDTO proyect) {
        this.proyect = proyect;
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

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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

    public SprintDTO fromEntities(
        Sprint sprint, 
        Proyect proyect, 
        User user, 
        Statuses statusSprint, 
        Statuses statusProject
        ) {
        this.id = sprint.getId();
        this.name = sprint.getName();
        this.description = sprint.getDescription();
        this.proyectId = sprint.getProyectId();
        this.proyect = new ProyectDTO().fromEntities(proyect, user, statusProject);
        this.statusId = sprint.getStatusId();
        this.status = new StatusesDTO().fromEntities(statusSprint);
        this.endDate = sprint.getEndDate();
        this.updatedAt = sprint.getUpdatedAt();
        this.createdAt = sprint.getCreatedAt();
        return this;
    }

}
