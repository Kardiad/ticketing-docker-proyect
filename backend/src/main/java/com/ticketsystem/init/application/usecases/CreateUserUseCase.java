package com.ticketsystem.init.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.init.application.dtos.UserDTO;
import com.ticketsystem.init.domain.entities.UserDAO;
import com.ticketsystem.init.infrastructure.persistence.UserRepository;
import com.ticketsystem.init.infrastructure.services.PasswordService;


@Service
public class CreateUserUseCase {

    @Autowired UserRepository userRepository;
    @Autowired PasswordService passwordService;
    
    public UserDTO execute(UserDTO entity) {
        // Implementation for creating a user
        UserDAO user = new UserDAO(
            entity.getUsername(), 
            this.passwordService.hashing(entity.getPassword())
        );        
        if(this.isValid(user)) {
           return userRepository.saveUser(user);
        }
        return null;
    }

    private boolean isValid(UserDAO user) {
        // Simple validation logic
        return
            user.getUsername() != null &&  // validamos que el nombre de usuario no sea nulo
            !user.getUsername().isEmpty() && //validamos que el nombre de usuario no esté vacio
            user.getPassword() != null && //validamos que la contraseña no sea nula
            !user.getPassword().isEmpty() && // validamos que haya un campo contraseña
            userRepository.findByUsername(user) == null; //validamos que no exista el usuario
    }

}
