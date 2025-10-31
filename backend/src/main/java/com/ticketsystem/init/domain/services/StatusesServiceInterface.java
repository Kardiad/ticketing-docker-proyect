package com.ticketsystem.init.domain.services;

import com.ticketsystem.init.application.dtos.StatusesDTO;
import com.ticketsystem.init.domain.entities.StatusesDAO;

public interface StatusesServiceInterface {
    public StatusesDTO findOne(StatusesDAO statusDAO);
}
