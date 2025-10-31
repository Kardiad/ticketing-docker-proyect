package com.ticketsystem.init.infrastructure.entities;

import jakarta.persistence.*;
import java.lang.String;

@Entity
@Table(name = "statuses")
public class Statuses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

	public Statuses(String name){
		this.name = name;
	}

	public Statuses() {
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
