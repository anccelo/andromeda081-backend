package com.angelolagreca.andromeda081backend.services;

import com.angelolagreca.andromeda081backend.model.CelestialObject;
import com.angelolagreca.andromeda081backend.model.entities.Planet;
import com.angelolagreca.andromeda081backend.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository planetRepository;

    public List<Planet> getPlanetsServices() {
        List<CelestialObject> AllCelestialObjects = planetRepository.findAll();
        return AllCelestialObjects.stream().filter(celObj -> celObj instanceof Planet).map(p -> (Planet) p)
                .collect(Collectors.toList());
    }

}
