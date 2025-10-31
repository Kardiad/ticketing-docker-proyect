package com.ticketsystem.init.domain.services;

import com.ticketsystem.init.application.dtos.SprintDTO;
import com.ticketsystem.init.domain.entities.SprintDAO;

public interface SprintServiceInterface {
    public SprintDTO create(SprintDAO sprintDao);
}
