package com.angelolagreca.andromeda081backend.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Moons extends CelestialObject implements SolarSystemObject {

    @OneToOne
    Planet satelliteOf;

    public Moons(final UUID id, final String name, Planet satelliteOf) {
        this.id = id;
        this.name = name;
        this.satelliteOf = satelliteOf;
    }
}
