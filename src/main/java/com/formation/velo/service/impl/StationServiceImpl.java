package com.formation.velo.service.impl;

import com.formation.velo.api.client.velo.OpenData;
import com.formation.velo.api.client.velo.OpenDateNantesVeloClient;
import com.formation.velo.model.Station;
import com.formation.velo.repository.StationRepository;
import com.formation.velo.service.StationService;
import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Log
@Getter
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository repository) {
        this.stationRepository = repository;
    }
    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }
    @Override
    public Optional<Station> findById(Integer id) {
        return stationRepository.findById(id);
    }

    @Override
    public Station add(Station station) {
        return stationRepository.save(station);
    }
    @Override
    public void getDatas() {
        //call openDatas
        String baseUrl = "https://data.nantesmetropole.fr/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).
                build();
        OpenDateNantesVeloClient client = retrofit.create(OpenDateNantesVeloClient.class);
        Call<OpenData> openDataNantesCall = client.getData();

        try {
            // save datas in station
            OpenData openDataNantes = openDataNantesCall.execute().body();

            assert openDataNantes != null;
            Arrays.stream(openDataNantes.getRecords()).forEach(record -> {
                Optional<Station> station = findByRecordId(record.getRecordId());
                if (station.isPresent()){
                    // on update la station
                    station.get().setStatus(record.getField().getStatus());
                    station.get().setAvailableBikeStands(record.getField().getAvailableBikeStands());
                    station.get().setAvailableBikes(record.getField().getAvailableBikes());
                    station.get().setBikeStands(record.getField().getBikeStands());
                    // position
                    station.get().setLattitude(record.getField().getPosition()[0]);
                    station.get().setLongitude(record.getField().getPosition()[1]);

                    add(station.get());

                }else {
                    Station newStation = Station.builder()
                            .recordId(record.getRecordId())
                            .name(record.getField().getName())
                            .status(record.getField().getStatus())
                            .address(record.getField().getAddress())
                            .availableBikes(record.getField().getAvailableBikes())
                            .availableBikeStands(record.getField().getAvailableBikeStands())
                            .bikeStands(record.getField().getBikeStands())
                            .lattitude(record.getField().getPosition()[0])
                            .longitude(record.getField().getPosition()[1])
                            .build();

                    add(newStation);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Optional<Station> findByRecordId(String recordId){
        return stationRepository.findByRecordId((recordId));
    }
}