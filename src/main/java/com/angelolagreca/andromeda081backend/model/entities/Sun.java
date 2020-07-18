package com.angelolagreca.andromeda081backend.model.entities;

import com.angelolagreca.andromeda081backend.model.CelestialObject;
import com.angelolagreca.andromeda081backend.model.SolarSystemObject;
import com.angelolagreca.andromeda081backend.model.Star;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
public class Sun extends CelestialObject implements SolarSystemObject, Star {

    final private double DiameterInKm = 1_391_000;

    private Sun(final String name) {
        super.name = name;
    }

    private static class SunHolder {
        private final static Sun instance = new Sun("Sun");
    }

    public static Sun getIstance() {
        return SunHolder.instance;
    }

}
