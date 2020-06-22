package com.angelolagreca.andromeda081backend.model.entities;

import com.angelolagreca.andromeda081backend.model.CelestialObject;
import com.angelolagreca.andromeda081backend.model.SolarSystemObject;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
public class Moons extends CelestialObject implements SolarSystemObject {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SATELLITE_OF_ID")
    private Planet satelliteOf;

    public Moons(final String name, final Planet satelliteOf) {
        super.name = name;
        this.satelliteOf = satelliteOf;
    }

}
