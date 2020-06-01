package com.angelolagreca.andromeda081backend;

import com.angelolagreca.andromeda081backend.model.CelestialObject;
import com.angelolagreca.andromeda081backend.model.SolarSystemObject;
import com.angelolagreca.andromeda081backend.model.entities.Moons;
import com.angelolagreca.andromeda081backend.model.entities.Planet;
import com.angelolagreca.andromeda081backend.model.entities.Sun;
import com.angelolagreca.andromeda081backend.repositories.MoonsRepository;
import com.angelolagreca.andromeda081backend.repositories.PlanetRepository;
import com.angelolagreca.andromeda081backend.repositories.SunRepository;
import com.angelolagreca.andromeda081backend.services.collector.PlanetCollector;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    PlanetCollector planetCollector;

    Planet mercury = new Planet("Mercury", 1);
    //Planet venus = new Planet("Venus", 2);
    //Planet venus = planetCollector.collect();
    Planet earth = new Planet("Earth", 3);
    //Moons neith = new Moons("Neith", venus);
    //Moons venusMoons2 = new Moons("venusMoons2", venus);
    //Moons moon = new Moons("moon", earth);
    Sun sun = Sun.getIstance();

    List<CelestialObject> celestialObjects = new ArrayList<>();

    public Andromeda081BackendApplication() throws JsonProcessingException {
    }

    public static void main(String[] args) {
        SpringApplication.run(Andromeda081BackendApplication.class, args);

    }

    @Bean
    public void run() throws JsonProcessingException {
        addItemsToCelestialObjects();
        persisteItems();
        read();
    }

    public void addItemsToCelestialObjects() throws JsonProcessingException {
        celestialObjects.add(planetCollector.collect("mercure"));
        celestialObjects.add(planetCollector.collect("venus"));
        // celestialObjects.add(neith);
        celestialObjects.add(sun);
        celestialObjects.add(planetCollector.collect("terre"));
        celestialObjects.add(planetCollector.collect("jupiter"));
        celestialObjects.add(planetCollector.collect("saturne"));
        //celestialObjects.add(moon);
        //celestialObjects.add(venusMoons2);
    }

    public void persisteItems() {
        for (CelestialObject celestialObject : celestialObjects) {
            if (celestialObject instanceof Planet) planetRepository.save(celestialObject);
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
//        System.out.println(moonsRepository.findByName("Neith").getSatelliteOf());
        List<CelestialObject> allPlanets = planetRepository.findAll();
        for (CelestialObject planet : allPlanets) {
            if (planet instanceof Planet) {
                System.out.println(planet);
            }
        }
        /*Page<Moons> moonsOfVenus = moonsRepository.findBySatelliteOf(venus, null);
        for (Moons moon : moonsOfVenus) {
            Logger.getAnonymousLogger().info(moon.toString());
        }*/
    }

}
