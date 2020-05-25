package com.angelolagreca.andromeda081backend.repositories;

import com.angelolagreca.andromeda081backend.entities.CelestialObject;
import com.angelolagreca.andromeda081backend.entities.Planet;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanetRepository extends JpaRepository<CelestialObject, UUID> {
    public Planet findByName(String name);
    //public Planet findByUUID(UUID uuid);
}
