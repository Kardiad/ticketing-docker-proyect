package com.ticketsystem.init.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.init.infrastructure.entities.Statuses;
import com.ticketsystem.init.infrastructure.persistence.ProjectRepository;
import com.ticketsystem.init.infrastructure.persistence.StatusesRepository;
import com.ticketsystem.init.infrastructure.persistence.UserRepository;
import com.ticketsystem.init.application.dtos.ProyectDTO;
import com.ticketsystem.init.application.dtos.StatusesDTO;
import com.ticketsystem.init.application.dtos.UserDTO;
import com.ticketsystem.init.domain.entities.ProyectDAO;
import com.ticketsystem.init.domain.entities.StatusesDAO;
import com.ticketsystem.init.domain.entities.UserDAO;

@Service
public class CreateProyectUseCase {

    @Autowired
    ProjectRepository proyectService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    StatusesRepository statusesRepository;

    public ProyectDTO execute(ProyectDTO proyect) {
        ProyectDAO dao = new ProyectDAO(
                null,
                proyect.getCreatedBy(),
                null,
                proyect.getName(),
                proyect.getDescription(),
                proyect.getStatusId() == null ? 1 : proyect.getStatusId(),
                null,
                proyect.getUpdatedAt(),
                proyect.getCreatedAt());
        if (this.isValid(dao)) {
            return proyectService.create(dao);
        }
        return null;
    }

    private boolean isValid(ProyectDAO proyect) {
        StatusesDTO statuses = statusesRepository.findOne(new StatusesDAO(proyect.getStatusId(), ""));
        UserDTO user = userRepository.findOne(new UserDAO(proyect.getCreatedBy(), "", ""));
        return proyect.getCreatedBy() != null
                && !proyect.getName().equals("")
                && !proyect.getName().isEmpty()
                && statuses != null
                && user != null;

    }

}
