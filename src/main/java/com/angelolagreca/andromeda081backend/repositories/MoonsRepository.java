package com.angelolagreca.andromeda081backend.repositories;

import com.angelolagreca.andromeda081backend.entities.CelestialObject;
import com.angelolagreca.andromeda081backend.entities.Moons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MoonsRepository extends JpaRepository<CelestialObject, UUID> {
   Moons findByName(String name);
}
