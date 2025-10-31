package com.ticketsystem.init.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import com.ticketsystem.init.application.dtos.StatusesDTO;
import com.ticketsystem.init.domain.entities.StatusesDAO;
import com.ticketsystem.init.domain.repositories.StatusesRepositoryInterface;
import com.ticketsystem.init.domain.services.StatusesServiceInterface;
import com.ticketsystem.init.infrastructure.entities.Statuses;

import jakarta.transaction.Transactional;

@Repository
public class StatusesRepository implements StatusesServiceInterface {
    
    private final StatusesRepositoryInterface statusesRepositoryInterface;

    public StatusesRepository(
        StatusesRepositoryInterface statusesRepositoryInterface
    ){
        this.statusesRepositoryInterface = statusesRepositoryInterface;
    }
    
    @Override
    @Transactional
    public StatusesDTO findOne(StatusesDAO statusDAO){
        Statuses status = this.statusesRepositoryInterface.findById(statusDAO.getId()).get();
        if(status != null){
            return new StatusesDTO().fromEntities(status);
        }
        return null;
    }

}
