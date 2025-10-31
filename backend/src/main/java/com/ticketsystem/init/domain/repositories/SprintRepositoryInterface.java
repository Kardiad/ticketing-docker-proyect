package com.ticketsystem.init.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ticketsystem.init.infrastructure.entities.Sprint;


public interface SprintRepositoryInterface extends CrudRepository<Sprint, Long> {

}
