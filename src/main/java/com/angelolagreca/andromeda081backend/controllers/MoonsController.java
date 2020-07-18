package com.angelolagreca.andromeda081backend.controllers;

import com.angelolagreca.andromeda081backend.model.CelestialObject;
import com.angelolagreca.andromeda081backend.model.entities.Moons;
import com.angelolagreca.andromeda081backend.model.entities.Planet;
import com.angelolagreca.andromeda081backend.services.MoonsService;
import com.angelolagreca.andromeda081backend.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController("")
public class MoonsController {

    @Autowired
    MoonsService moonsService;

    @GetMapping("moons")
    public List<Moons> getMoonsController() {
        return moonsService.getMoonsServices();
    }

    @GetMapping(value = "moons", params = "id")
    public Optional<CelestialObject> getMoonsController(@RequestParam Long id) {
        return moonsService.getMoonsService(id);
    }
}
