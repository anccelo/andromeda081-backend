package com.angelolagreca.andromeda081backend.services;

import com.angelolagreca.andromeda081backend.model.CelestialObject;
import com.angelolagreca.andromeda081backend.model.entities.Sun;
import com.angelolagreca.andromeda081backend.repositories.SunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SunService {
    @Autowired
    SunRepository sunRepository;

    public List<Sun> getSunService() {
         List<CelestialObject> celestialObjects =  sunRepository.findAll();
         return celestialObjects.stream().filter(celestialObject -> celestialObject instanceof Sun).map(s -> (Sun) s).
                 collect(Collectors.toList());
    }

}
