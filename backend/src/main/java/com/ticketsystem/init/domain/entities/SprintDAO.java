package com.ticketsystem.init.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class SprintDAO {
    
    private Long id;
    private String name;
	private String description;
	private Long proyectId;
    private ProyectDAO proyect;
	private Long statusId;
    private StatusesDAO status;
	private LocalDate endDate;
	private LocalDateTime updatedAt;
	private LocalDateTime createdAt;
    
    public SprintDAO(
        Long id,
        String name,
		String description,
		Long proyectId,
        ProyectDAO proyect,
		Long statusId,
        StatusesDAO status,
		LocalDate endDate,
		LocalDateTime updatedAt,
		LocalDateTime createdAt
    ){
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

    public ProyectDAO getProyect() {
        return this.proyect;
    }

    public void setProyect(ProyectDAO proyect) {
        this.proyect = proyect;
    }

    public Long getStatusId() {
        return this.statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public StatusesDAO getStatus() {
        return this.status;
    }

    public void setStatus(StatusesDAO status) {
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


}
