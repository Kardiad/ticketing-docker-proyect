package com.ticketsystem.init.domain.entities;

import java.time.LocalDateTime;

public class ProyectDAO {
    private Long id;
    private Long createdBy;
    private UserDAO createdByUser;
    private String name;
    private String description;
    private Long statusId;
    private StatusesDAO status;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    public ProyectDAO(
        Long id,
        Long createdBy,
        UserDAO createdByUser,
        String name,
        String description,
        Long statusId,
        StatusesDAO status,
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

    public UserDAO getCreatedByUser() {
        return this.createdByUser;
    }

    public void setCreatedByUser(UserDAO createdByUser) {
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

    public StatusesDAO getStatus() {
        return this.status;
    }

    public void setStatus(StatusesDAO status) {
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
}
