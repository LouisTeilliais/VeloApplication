package com.formation.velo.task;


import com.formation.velo.service.PumpService;
import com.formation.velo.service.StationService;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log
public class ScheduledTask {

    private final StationService stationService;
    private final PumpService pumpService;

    public ScheduledTask(StationService stationService, PumpService pumpService){
        this.stationService = stationService;
        this.pumpService = pumpService;
    }

    @Scheduled(fixedRate = 60000)
    public void searchNewMatchStation(){
        log.info("updating...");
        try {
            stationService.getDatas();
            log.info("✅ station update");
        } catch (Exception e) {
            log.info("❌ station not update");
        }
        try {
            pumpService.getDatas();
            log.info("✅ pump update");
        } catch (Exception e) {
            log.info("❌ pump not update");
        }
    }
}
