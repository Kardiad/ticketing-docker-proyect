package com.ticketsystem.init.infrastructure.persistence;
import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.ticketsystem.init.application.dtos.ProyectDTO;
import com.ticketsystem.init.application.dtos.StatusesDTO;
import com.ticketsystem.init.application.dtos.UserDTO;
import com.ticketsystem.init.domain.entities.ProyectDAO;
import com.ticketsystem.init.domain.repositories.ProyectRepositoryInterface;
import com.ticketsystem.init.domain.repositories.StatusesRepositoryInterface;
import com.ticketsystem.init.domain.repositories.UserRepositoryInterface;
import com.ticketsystem.init.domain.services.ProjectServiceInterface;
import com.ticketsystem.init.infrastructure.entities.Proyect;
import com.ticketsystem.init.infrastructure.entities.Statuses;
import com.ticketsystem.init.infrastructure.entities.User;

import jakarta.transaction.Transactional;

@Repository
public class ProjectRepository implements ProjectServiceInterface  {

    final private ProyectRepositoryInterface proyectRepositoryInterface;
    final private UserRepositoryInterface userRepositoryInterface;
    final private StatusesRepositoryInterface statusesRepositoryInterface;

    public ProjectRepository(
        ProyectRepositoryInterface proyectRepositoryInterface,
        UserRepositoryInterface userRepositoryInterface,
        StatusesRepositoryInterface statusesRepositoryInterface
    ){
        this.proyectRepositoryInterface = proyectRepositoryInterface;
        this.userRepositoryInterface = userRepositoryInterface;
        this.statusesRepositoryInterface = statusesRepositoryInterface;
    }

    @Override
    @Transactional
    public ProyectDTO create(ProyectDAO proyect) {
        Proyect entity = new Proyect(
            proyect.getCreatedBy(),
            proyect.getName(),
            proyect.getDescription(),
            proyect.getStatusId(),
            proyect.getUpdatedAt(),
            LocalDateTime.now()
        );
        entity = this.proyectRepositoryInterface.save(entity);
        User user = userRepositoryInterface.findById(entity.getCreatedBy()).get();
        Statuses status = statusesRepositoryInterface.findById(entity.getStatusId()).get();
        return new ProyectDTO().fromEntities(entity, user, status);
    }

    @Override
    @Transactional
    public ProyectDTO findOne(ProyectDAO proyect) {
        Proyect proyectEntity = this.proyectRepositoryInterface.findById(proyect.getId()).get();
        if(proyectEntity != null){
            User user = userRepositoryInterface.findById(proyectEntity.getCreatedBy()).get();
            Statuses status = statusesRepositoryInterface.findById(proyectEntity.getStatusId()).get();
            return new ProyectDTO().fromEntities(proyectEntity, user, status);
        }
        return null;
    }
    
}
