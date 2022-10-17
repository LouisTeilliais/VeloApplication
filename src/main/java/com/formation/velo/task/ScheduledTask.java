package com.formation.velo.task;


import com.formation.velo.service.StationService;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log
public class ScheduledTask {

    private final StationService stationService;

    public ScheduledTask(StationService stationService){
        this.stationService = stationService;
    }

    @Scheduled(fixedRate = 60000)
    public void searchNewMatchStation(){
        log.info(" \uD83D\uDD04 update station");
        stationService.getDatas();
    }
}
