package com.ticketsystem.init.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.init.application.dtos.ProyectDTO;
import com.ticketsystem.init.application.dtos.SprintDTO;
import com.ticketsystem.init.application.dtos.StatusesDTO;
import com.ticketsystem.init.domain.entities.ProyectDAO;
import com.ticketsystem.init.domain.entities.SprintDAO;
import com.ticketsystem.init.domain.entities.StatusesDAO;
import com.ticketsystem.init.infrastructure.persistence.ProjectRepository;
import com.ticketsystem.init.infrastructure.persistence.SprintRepository;
import com.ticketsystem.init.infrastructure.persistence.StatusesRepository;
import com.ticketsystem.init.infrastructure.persistence.UserRepository;

@Service
public class CreateSprintUseCase {
    
    @Autowired
    SprintRepository sprintRepository;
    @Autowired
    ProjectRepository proyectService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    StatusesRepository statusesRepository;

    public SprintDTO execute(SprintDTO entityDto){
        SprintDAO entityDao = new SprintDAO(
            null,
            entityDto.getName(),
            entityDto.getDescription(),
            entityDto.getProyectId(),
            null,
            entityDto.getStatusId(),
            null,
            entityDto.getEndDate(),
            entityDto.getUpdatedAt(),
            entityDto.getCreatedAt()
        );
        if(this.isValid(entityDao)){
            return this.sprintRepository.create(entityDao);
        }
        return null;
    }

    private boolean isValid(SprintDAO entityDao){
        ProyectDTO proyect = this.proyectService.findOne(new ProyectDAO(
            entityDao.getId(),
            null, 
            null, 
            null, 
            null, 
            null, 
            null, 
            null, 
            null)
        );
        StatusesDTO status = this.statusesRepository.findOne(new StatusesDAO(
            entityDao.getStatusId(),
             null)
        );
        return 
            !entityDao.getName().equals("")
            && !entityDao.getName().isEmpty()
            && proyect != null
            && status != null;
    }

}
