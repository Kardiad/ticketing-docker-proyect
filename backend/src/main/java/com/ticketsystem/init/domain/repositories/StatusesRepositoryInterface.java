package com.ticketsystem.init.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ticketsystem.init.infrastructure.entities.Statuses;


public interface StatusesRepositoryInterface extends CrudRepository<Statuses, Long> {
}
