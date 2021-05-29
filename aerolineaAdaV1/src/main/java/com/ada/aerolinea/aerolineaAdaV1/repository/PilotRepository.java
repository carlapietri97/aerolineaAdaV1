package com.ada.aerolinea.aerolineaAdaV1.repository;

import com.ada.aerolinea.aerolineaAdaV1.model.Pilot;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PilotRepository extends CrudRepository<Pilot, Integer> {

    Optional<Pilot> findByName(String name);

}
