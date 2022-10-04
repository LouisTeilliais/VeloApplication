package com.formation.velo.service.impl;

import com.formation.velo.model.Station;
import com.formation.velo.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class StationServiceImpl implements Serializable {

    private final StationRepository stationRepository;


    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }


    public List<Station> findAll(){
        return stationRepository.findAll();
    }
}
