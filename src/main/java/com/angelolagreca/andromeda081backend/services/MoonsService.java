package com.angelolagreca.andromeda081backend.services;

import com.angelolagreca.andromeda081backend.model.CelestialObject;
import com.angelolagreca.andromeda081backend.model.entities.Moons;
import com.angelolagreca.andromeda081backend.repositories.MoonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MoonsService {

    @Autowired
    MoonsRepository moonsRepository;

    public List<Moons> getMoonsServices() {
        List<CelestialObject> AllCelestialObjects = moonsRepository.findAll();
        return AllCelestialObjects.stream().filter(celObj -> celObj instanceof Moons).map(p -> (Moons) p)
                .collect(Collectors.toList());
    }

    public Optional<CelestialObject> getMoonsService(Long id) {
        Optional<CelestialObject> response = moonsRepository.findById(id);
        if (response.isEmpty()) {
            System.err.println(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
