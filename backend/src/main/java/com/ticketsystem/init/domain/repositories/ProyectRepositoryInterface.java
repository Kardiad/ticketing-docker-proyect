package com.ticketsystem.init.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ticketsystem.init.infrastructure.entities.Proyect;


public interface ProyectRepositoryInterface extends CrudRepository<Proyect, Long> {

}
