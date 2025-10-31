package com.ticketsystem.init.domain.services;

import com.ticketsystem.init.application.dtos.ProyectDTO;
import com.ticketsystem.init.domain.entities.ProyectDAO;

public interface ProjectServiceInterface {
    public ProyectDTO create(ProyectDAO proyect);
    public ProyectDTO findOne(ProyectDAO proyect);
}