package com.ticketsystem.init.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import com.ticketsystem.init.application.dtos.UserDTO;
import com.ticketsystem.init.domain.entities.UserDAO;
import com.ticketsystem.init.domain.repositories.UserRepositoryInterface;
import com.ticketsystem.init.domain.services.UserServiceInterface;
import com.ticketsystem.init.infrastructure.entities.User;

import jakarta.transaction.Transactional;

@Repository
public class UserRepository implements UserServiceInterface {

    final private UserRepositoryInterface userRepository;

    public UserRepository(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDTO saveUser(UserDAO user) {
        // Implementation for saving user to the database
        User userEntity = new User();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        User userSaved = this.userRepository.save(userEntity);
        return new UserDTO(
                userSaved.getId(),
                userSaved.getUsername(),
                userSaved.getPassword());
    }

    @Override
    @Transactional
    public UserDTO findByUsername(UserDAO user) {
        User foundUser = this.userRepository.findByUsername(user.getUsername());
        if (foundUser != null) {
            return new UserDTO(
                    foundUser.getId(),
                    foundUser.getUsername(),
                    foundUser.getPassword());
        }
        return null;
    }

    @Override
    @Transactional
    public UserDTO findOne(UserDAO user) {
        User userEntity = this.userRepository.findById(user.getId()).get();
        if(userEntity != null){
            return new UserDTO(
                userEntity.getId(),
                userEntity.getUsername(),
                ""
            );
        }
        return null;
    }
}
