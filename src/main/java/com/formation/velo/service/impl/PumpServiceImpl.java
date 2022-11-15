package com.formation.velo.service.impl;

import com.formation.velo.api.client.pump.OpenData;
import com.formation.velo.api.client.pump.OpenDataNantesClient;
import com.formation.velo.model.Pump;
import com.formation.velo.repository.PumpRepository;
import com.formation.velo.service.PumpService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
public class PumpServiceImpl implements PumpService {

    private final PumpRepository pumpRepository;

    public PumpServiceImpl(PumpRepository repository) {
        this.pumpRepository = repository;
    }

    @Override
    public Pump add(Pump pump) {
        return pumpRepository.save(pump);
    }

    @Override
    public List<Pump> findAll() {
        return pumpRepository.findAll();
    }

    @Override
    public Optional<Pump> findById(Integer id){
        return pumpRepository.findById(id);
    }

    @Override
    public Optional<Pump> findByRecordId(String recordId){
        return pumpRepository.findByRecordId((recordId));
    }

    @Override
    public void getDatas() {
        String urlBase = "https://data.economie.gouv.fr/";
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(urlBase).addConverterFactory(GsonConverterFactory.create(gson)).build();

        OpenDataNantesClient client = retrofit.create(OpenDataNantesClient.class);
        Call<OpenData> openDataPumpNantesCall = client.getData();

        try {
            OpenData openDataPump = openDataPumpNantesCall.execute().body();

            assert openDataPump != null;
            Arrays.stream(openDataPump.getRecords()).forEach(record -> {
                Optional<Pump> pump = findByRecordId(record.getRecordId());
                if(pump.isPresent()) {
                    pump.get().setLongitude(record.getField().getPosition()[1]);
                    pump.get().setLatitude(record.getField().getPosition()[0]);
                    pump.get().setUpdateDate(record.getField().getUpdatePrice());
                    pump.get().setPrice(record.getField().getPrice());

                    add(pump.get());
                } else {
                    Pump newPump = Pump.builder()
                            .recordId(record.getRecordId())
                            .reg_name(record.getField().getRegionName())
                            .longitude(record.getField().getPosition()[1])
                            .latitude(record.getField().getPosition()[0])
                            .price(record.getField().getPrice())
                            .updateDate(record.getField().getUpdatePrice())
                            .adress(record.getField().getAdress())
                            .city(record.getField().getCity())
                            .services_service(record.getField().getServicesService())
                            .horaires_automate(record.getField().getHorairesAutomate24_24())
                            .build();

                    add(newPump);
                }
            });
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}