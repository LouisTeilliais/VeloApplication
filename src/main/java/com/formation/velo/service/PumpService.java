package com.formation.velo.service;

import com.formation.velo.model.Pump;

import java.util.List;
import java.util.Optional;

public interface PumpService {

    List<Pump> findAll();
    Pump add(Pump pump);

    Optional<Pump> findById(Integer id);

    void getDatas();

    Optional<Pump> findByRecordId(String recordId);
}
