package com.angelolagreca.andromeda081backend.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
public class Moons extends CelestialObject implements SolarSystemObject {

    @ManyToOne
    @JoinColumn(nullable = false)
    Planet satelliteOf;

    public Moons(final Long id, final String name, Planet satelliteOf) {
        this.id = id;
        this.name = name;
        this.satelliteOf = satelliteOf;
    }
}
