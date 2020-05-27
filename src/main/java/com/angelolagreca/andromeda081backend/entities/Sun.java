package com.angelolagreca.andromeda081backend.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Sun extends CelestialObject implements SolarSystemObject, Star {

    final private double DiameterInKm = 1_391_000;

    private Sun(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    private static class SunHolder {
        private final static Sun instance = new Sun(null, "Sun");
    }

    public static Sun getIstance() {
        return SunHolder.instance;
    }


}
