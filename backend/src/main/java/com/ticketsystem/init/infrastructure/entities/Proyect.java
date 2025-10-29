package com.ticketsystem.init.infrastructure.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.lang.Integer;
import java.lang.String;
import java.lang.Long;

@Entity
@Table(name = "proyect")
public class Proyect {

	public Proyect() {
	}

	@Column(name = "created_at", nullable = true)
	private LocalDateTime createdAt;

	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "created_by", nullable = true)
	private Integer createdBy;

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "description", length = 65535, nullable = true)
	private String description;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "status_id", nullable = true)
	private Integer statusId;

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	@Column(name = "updated_at", nullable = true)
	private LocalDateTime updatedAt;

	public LocalDateTime getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
