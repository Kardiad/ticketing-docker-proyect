package com.ticketsystem.init.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ticketsystem.init.infrastructure.entities.User;


public interface UserRepositoryInterface extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}
