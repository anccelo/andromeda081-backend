package com.angelolagreca.andromeda081backend;

import com.angelolagreca.andromeda081backend.entities.CelestialObject;
import com.angelolagreca.andromeda081backend.entities.Moons;
import com.angelolagreca.andromeda081backend.entities.Planet;
import com.angelolagreca.andromeda081backend.repositories.MoonsRepository;
import com.angelolagreca.andromeda081backend.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Andromeda081BackendApplication {

    @Autowired
    PlanetRepository planetRepository;
    @Autowired
    MoonsRepository moonsRepository;

    Planet mercury = new Planet(null, "Mercury", 1, null);
    Planet venus = new Planet(null, "Venus", 2, null);
    Moons neith = new Moons(null, "Neith", venus);

    List<CelestialObject> celestialObjects = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Andromeda081BackendApplication.class, args);

    }

    @Bean
    public void run() {
        celestialObjects.add(mercury);
        celestialObjects.add(venus);
        celestialObjects.add(neith);
        for (CelestialObject celestialObject : celestialObjects) {
            if (celestialObject instanceof Planet)
                planetRepository.save(celestialObject);
            if (celestialObject instanceof Moons) {
                moonsRepository.save(celestialObject);
            }
        }
    }

    @Bean
    public void read(){
        System.out.println(planetRepository.findByName("Mercury").getName());
       // System.out.println(moonsRepository.findByName("Neith"));
    }

}
