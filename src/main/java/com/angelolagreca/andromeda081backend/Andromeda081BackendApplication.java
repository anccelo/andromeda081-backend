package com.angelolagreca.andromeda081backend;

import com.angelolagreca.andromeda081backend.entities.*;
import com.angelolagreca.andromeda081backend.repositories.MoonsRepository;
import com.angelolagreca.andromeda081backend.repositories.PlanetRepository;
import com.angelolagreca.andromeda081backend.repositories.SunRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class Andromeda081BackendApplication {

    @Autowired
    PlanetRepository planetRepository;
    @Autowired
    MoonsRepository moonsRepository;
    @Autowired
    SunRepository sunRepository;

    Planet mercury = new Planet(null, "Mercury", 1);
    Planet venus = new Planet(null, "Venus", 2);
    Planet earth = new Planet(null, "Earth", 3);
    Moons neith = new Moons(null, "Neith", venus);
    Moons venusMoons2 = new Moons(null, "venusMoons2", venus);
    Moons moon = new Moons(null, "moon", earth);
    Sun sun = Sun.getIstance();

    List<CelestialObject> celestialObjects = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Andromeda081BackendApplication.class, args);

    }

    @Bean
    public void run() {
        addItemsToCelestialObjects();
        persisteItems();
        read();
    }

    public void addItemsToCelestialObjects() {

        celestialObjects.add(mercury);
        celestialObjects.add(venus);
        celestialObjects.add(neith);
        celestialObjects.add(sun);
        celestialObjects.add(earth);
        celestialObjects.add(moon);
        celestialObjects.add(venusMoons2);
    }

    public void persisteItems() {
        for (CelestialObject celestialObject : celestialObjects) {
            if (celestialObject instanceof Planet)
                planetRepository.save(celestialObject);
            if (celestialObject instanceof Moons) {
                moonsRepository.save(celestialObject);
            }
            if (celestialObject instanceof Sun) {
                moonsRepository.save(celestialObject);
            }
            if (celestialObject instanceof SolarSystemObject) {
                System.out.println(celestialObject + " is a Solar System Object");
            } else {
                System.out.println(celestialObject + " is NOT A SSO");
            }
        }
    }

    public void read() {
        System.out.println(planetRepository.findByName("Mercury"));
        System.out.println(moonsRepository.findByName("Neith").getSatelliteOf());
        List<CelestialObject> allPlanets = planetRepository.findAll();
        for (CelestialObject planet : allPlanets) {
            if (planet instanceof Planet) {
                System.out.println(planet);
            }
        }
        Page<Moons> moonsOfVenus = moonsRepository.findBySatelliteOf(venus, null);
        for (Moons moon : moonsOfVenus) {
            Logger.getAnonymousLogger().info(moon.toString());
        }
    }


}
