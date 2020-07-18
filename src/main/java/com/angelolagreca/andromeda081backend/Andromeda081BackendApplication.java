package com.angelolagreca.andromeda081backend;

import com.angelolagreca.andromeda081backend.exception.Andromeda081Exception;
import com.angelolagreca.andromeda081backend.exception.GenericException;
import com.angelolagreca.andromeda081backend.model.CelestialObject;
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

import java.util.*;

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

    private final static List<String> PLANETS_NAME = new ArrayList<>(Arrays.asList("mercure", "venus", "terre", "mars",
            "jupiter", "saturne", "uranus", "neptune"));
    private static final CelestialObject SUN = Sun.getIstance();

    Map<String, CelestialObject> celestialObjects = new TreeMap<>() {
    };

    public Andromeda081BackendApplication() throws JsonProcessingException {
    }

    public static void main(String[] args) {
        SpringApplication.run(Andromeda081BackendApplication.class, args);
    }

    @Bean
    public void run() throws JsonProcessingException {
        addItemsToCelestialObjects();
        persisteItems();
    }

    public void addItemsToCelestialObjects() throws JsonProcessingException {
        // moons must always be added after the planets
        celestialObjects.put(SUN.getName(), SUN);
        try {
            for (String planetName : PLANETS_NAME) {
                celestialObjects.put(planetName, planetCollector.collect(planetName));
            }
        } catch (Andromeda081Exception andromeda081Exception) {
            Andromeda081Exception andromeda081Exception1 = new GenericException("There is a problem.");
            // todo refactoring exception
        }
        final CelestialObject europe = new Moons("europa", (Planet) celestialObjects.get("jupiter"), 10, 10,10,10,10);
        celestialObjects.put("europe", europe);
    }

    public void persisteItems() {
        for (CelestialObject celestialObject : celestialObjects.values()) {
            if (celestialObject instanceof Planet) planetRepository.save(celestialObject);
            if (celestialObject instanceof Moons) {
                moonsRepository.save(celestialObject);
            }
            if (celestialObject instanceof Sun) {
                sunRepository.save(celestialObject);
            }
        }
    }

}
