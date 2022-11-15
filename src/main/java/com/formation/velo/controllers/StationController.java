package com.formation.velo.controllers;

import com.formation.velo.model.Station;
import com.formation.velo.service.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class StationController {


    // BACK STATIONS
    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("stations")
    public ResponseEntity<List<Station>> GetAll (){
        stationService.getDatas();
        List<Station> stations = stationService.findAll();

        return ResponseEntity.ok(stations);
    }

    @GetMapping("stations/{id}")
    public ResponseEntity<Optional<Station>> GetById(@PathVariable Integer id){
        Optional<Station> station = stationService.findById(id);

        return ResponseEntity.ok(station);
    }
}
