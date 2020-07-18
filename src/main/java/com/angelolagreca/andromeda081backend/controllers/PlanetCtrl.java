package com.angelolagreca.andromeda081backend.controllers;

import com.angelolagreca.andromeda081backend.exception.Andromeda081Exception;
import com.angelolagreca.andromeda081backend.exception.GenericException;
import com.angelolagreca.andromeda081backend.model.CelestialObject;
import com.angelolagreca.andromeda081backend.model.entities.Planet;
import com.angelolagreca.andromeda081backend.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class PlanetCtrl {

    private final PlanetService planetService;

    @Autowired
    public PlanetCtrl(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("planets")
    public List<Planet> getPlanetsController() {
        return planetService.getPlanetsService();
    }

    @GetMapping(value = "planets", params = "id")
    public Optional<CelestialObject> getPlanetController(@RequestParam Long id) {
        Optional<CelestialObject> response = planetService.getPlanetService(id);
        try {
            if (response.isEmpty()) {
                throw new GenericException("the requested id does not exist");
            }
        } catch (Andromeda081Exception genericException) {
            genericException.printStackTrace();
        } finally {
            return response;
        }
    }
}
