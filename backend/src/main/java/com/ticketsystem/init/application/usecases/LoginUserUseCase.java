package com.ticketsystem.init.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.init.application.dtos.UserDTO;
import com.ticketsystem.init.domain.entities.UserDAO;
import com.ticketsystem.init.infrastructure.persistence.UserRepository;
import com.ticketsystem.init.infrastructure.services.PasswordService;

@Service
public class LoginUserUseCase {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordService passwordService;

    public UserDTO execute(UserDTO entity) {
        UserDAO userDao = null;
        UserDTO userDto = null;
        if (this.isValid(entity)) {
            userDao = new UserDAO(entity.getUsername(), entity.getPassword());
        }
        if (userDao != null) {
            userDto = this.userRepository.findByUsername(userDao);
        }        
        if (userDto != null && this.passwordValid(userDao, userDto)) {
            userDto.setPassword("");
            return userDto;
        }
        return null;
    }

    private boolean passwordValid(UserDAO entity, UserDTO userDto){
        return this.passwordService.verifyPassword(entity.getPassword(), userDto.getPassword());
    }

    private boolean isValid(UserDTO user) {
        return !user.getPassword().isEmpty() &&
                !user.getPassword().equals("") &&
                !user.getUsername().isEmpty() &&
                !user.getUsername().equals("");
    }

}