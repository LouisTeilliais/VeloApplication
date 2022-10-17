package com.formation.velo.service;

import com.formation.velo.model.Station;

import java.util.List;
import java.util.Optional;

public interface StationService {

    List<Station> findAll();

    Station add(Station station);
    Optional<Station> findById(Integer id);
    void getDatas();
    Optional<Station> findByRecordId(String recordId);
}
