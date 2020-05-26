package com.angelolagreca.andromeda081backend.repositories;

import com.angelolagreca.andromeda081backend.entities.CelestialObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SunRepository extends JpaRepository<CelestialObject,Long> {
}
