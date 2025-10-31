package com.ticketsystem.init.infrastructure.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.lang.String;
import java.time.LocalDate;

@Entity
@Table(name = "sprint")
public class Sprint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "created_at", nullable = true)
	private LocalDateTime createdAt;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "description", length = 65535, nullable = true)
	private String description;

	@Column(name = "proyect_id", nullable = true)
	private Long proyectId;

	@Column(name = "status_id", nullable = true)
	private Long statusId;

	@Column(name = "end_date", nullable = true)
	private LocalDate endDate;

	@Column(name = "updated_at", nullable = true)
	private LocalDateTime updatedAt;

	public Sprint() {
	}

	public Sprint(			
		String name,
		String description,
		Long proyectId,
		Long statusId,
		LocalDate endDate,
		LocalDateTime updatedAt,
		LocalDateTime createdAt
	) {		
		this.name = name;
		this.description = description;
		this.proyectId = proyectId;
		this.statusId = statusId;
		this.endDate = endDate;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
	}

	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getEndDate() {
		return this.endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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

	public Long getProyectId() {
		return this.proyectId;
	}

	public void setProyectId(Long proyectId) {
		this.proyectId = proyectId;
	}

	@Column(name = "start_date", nullable = true)
	private LocalDate startDate;

	public LocalDate getStartDate() {
		return this.startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public LocalDateTime getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
