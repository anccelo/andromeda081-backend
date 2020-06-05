package com.angelolagreca.andromeda081backend.controllers;

import com.angelolagreca.andromeda081backend.model.entities.Planet;
import com.angelolagreca.andromeda081backend.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("")
public class PlanetCtrl {

    @Autowired
    PlanetService planetService;

    @GetMapping("planets")
    public List<Planet> getPlanetsController(){
        return planetService.getPlanetsServices();
    }

}
