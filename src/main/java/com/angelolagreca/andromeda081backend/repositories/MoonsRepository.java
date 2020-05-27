package com.angelolagreca.andromeda081backend.repositories;

import com.angelolagreca.andromeda081backend.entities.CelestialObject;
import com.angelolagreca.andromeda081backend.entities.Moons;
import com.angelolagreca.andromeda081backend.entities.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MoonsRepository extends JpaRepository<CelestialObject, Long> {
    Moons findByName(String name);

    Page<Moons> findBySatelliteOf(Planet satelliteOf, Pageable pageable);
}
