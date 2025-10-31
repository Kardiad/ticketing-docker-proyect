package com.ticketsystem.init.infrastructure.persistence;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.ticketsystem.init.application.dtos.SprintDTO;
import com.ticketsystem.init.domain.entities.SprintDAO;
import com.ticketsystem.init.domain.repositories.ProyectRepositoryInterface;
import com.ticketsystem.init.domain.repositories.SprintRepositoryInterface;
import com.ticketsystem.init.domain.repositories.StatusesRepositoryInterface;
import com.ticketsystem.init.domain.repositories.UserRepositoryInterface;
import com.ticketsystem.init.domain.services.SprintServiceInterface;
import com.ticketsystem.init.infrastructure.entities.Proyect;
import com.ticketsystem.init.infrastructure.entities.Sprint;
import com.ticketsystem.init.infrastructure.entities.Statuses;
import com.ticketsystem.init.infrastructure.entities.User;

import jakarta.transaction.Transactional;

@Repository
public class SprintRepository implements SprintServiceInterface {

    final private UserRepositoryInterface userRepository;
    final private SprintRepositoryInterface sprintRepository;
    final private ProyectRepositoryInterface proyectRepsoitory;
    final private StatusesRepositoryInterface statusRepository;

    public SprintRepository(
        UserRepositoryInterface userRepository,
        SprintRepositoryInterface sprintRepository,
        ProyectRepositoryInterface proyectRepository,
        StatusesRepositoryInterface statusesRepository
        ) {
        this.userRepository = userRepository;
        this.sprintRepository = sprintRepository;
        this.proyectRepsoitory = proyectRepository;
        this.statusRepository = statusesRepository;
    }

    @Override
    @Transactional
    public SprintDTO create(SprintDAO sprintDao) {
        Sprint entity = new Sprint(
            sprintDao.getName(), 
            sprintDao.getDescription(),
            sprintDao.getProyectId(),
            sprintDao.getStatusId(),
            sprintDao.getEndDate(),
            null,
            LocalDateTime.now()
        );
        entity = this.sprintRepository.save(entity);
        Proyect proyect = this.proyectRepsoitory.findById(entity.getProyectId()).get();
        Statuses statusProyect = this.statusRepository.findById(proyect.getStatusId()).get();
        Statuses statusEntity = this.statusRepository.findById(entity.getStatusId()).get();
        User user = this.userRepository.findById(proyect.getCreatedBy()).get();
        return new SprintDTO().fromEntities(entity, proyect, user, statusEntity, statusProyect);
    }
    
}
