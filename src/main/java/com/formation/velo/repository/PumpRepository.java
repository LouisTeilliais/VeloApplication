package com.formation.velo.repository;

import com.formation.velo.model.Pump;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PumpRepository extends JpaRepository<Pump, Integer> {

    Optional<Pump> findByRecordId(String recordId);
}
