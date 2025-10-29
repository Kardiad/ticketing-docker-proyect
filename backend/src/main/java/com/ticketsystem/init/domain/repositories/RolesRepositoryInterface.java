package com.ticketsystem.init.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ticketsystem.init.infrastructure.entities.Role;


public interface RolesRepositoryInterface extends CrudRepository<Role, Long> {

}
