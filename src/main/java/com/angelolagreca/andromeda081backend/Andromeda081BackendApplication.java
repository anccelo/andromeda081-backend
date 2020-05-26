package com.angelolagreca.andromeda081backend;

import com.angelolagreca.andromeda081backend.entities.*;
import com.angelolagreca.andromeda081backend.repositories.MoonsRepository;
import com.angelolagreca.andromeda081backend.repositories.PlanetRepository;
import com.angelolagreca.andromeda081backend.repositories.SunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Andromeda081BackendApplication {

    @Autowired
    PlanetRepository planetRepository;
    @Autowired
    MoonsRepository moonsRepository;
    @Autowired
    SunRepository sunRepository;

    Planet mercury = new Planet(null, "Mercury", 1 );
    Planet venus = new Planet(null, "Venus", 2);
    Moons neith = new Moons(null, "Neith", venus);
    Sun sun = Sun.getIstance();

    List<CelestialObject> celestialObjects = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Andromeda081BackendApplication.class, args);

    }

    @Bean
    public void run() {
        celestialObjects.add(mercury);
        celestialObjects.add(venus);
        celestialObjects.add(neith);
        celestialObjects.add(sun);
        for (CelestialObject celestialObject : celestialObjects) {
            if (celestialObject instanceof Planet)
                planetRepository.save(celestialObject);
            if (celestialObject instanceof Moons) {
                moonsRepository.save(celestialObject);
            }
            if (celestialObject instanceof Sun) {
                moonsRepository.save(celestialObject);
            }
            if (celestialObject instanceof SolarSystemObject){
                System.out.println(celestialObject + " is a Solar System Object");
            } else {
                System.out.println(celestialObject + " is NOT A SSO");
            }
        }

    }

    @Bean
    public void read(){
        System.out.println(planetRepository.findByName("Mercury"));
        System.out.println(moonsRepository.findByName("Neith").getSatelliteOf());
        List<CelestialObject> allPlanets = planetRepository.findAll();
    }



}
