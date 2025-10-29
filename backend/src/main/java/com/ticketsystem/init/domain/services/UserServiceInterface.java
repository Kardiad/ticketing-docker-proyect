package com.ticketsystem.init.domain.services;

import com.ticketsystem.init.application.dtos.UserDTO;
import com.ticketsystem.init.domain.entities.UserDAO;

public interface UserServiceInterface {
    public UserDTO saveUser(UserDAO user);    
    public UserDTO findByUsername(UserDAO user);
}
