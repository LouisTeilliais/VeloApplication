package com.formation.velo.controllers;

import com.formation.velo.model.Pump;
import com.formation.velo.service.PumpService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class PumpController {

    private final PumpService pumpService;

    public PumpController(PumpService pumpService) {
        this.pumpService = pumpService;
    }


    @GetMapping("pumps")
    public ResponseEntity<List<Pump>> GetAll (){
        pumpService.getDatas();
        List<Pump> pumps = pumpService.findAll();

        return ResponseEntity.ok(pumps);
    }

    @GetMapping("pumps/{id}")
    public ResponseEntity<Optional<Pump>> GetById(@PathVariable Integer id){
        Optional<Pump> pump = pumpService.findById(id);

        return ResponseEntity.ok(pump);
    }
}
