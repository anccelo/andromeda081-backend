package com.angelolagreca.andromeda081backend.model.entities;

import com.angelolagreca.andromeda081backend.model.CelestialObject;
import com.angelolagreca.andromeda081backend.model.SolarSystemObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Moons extends CelestialObject implements SolarSystemObject {

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "SATELLITE_OF_ID")
    private Planet satelliteOf;

    private double equatorialDiameterInKm;
    private double orbitalPeriodInDays;
    private double sideralRotationInDays;

    private double density;
    private double gravity;

    public Moons(
            final @JsonProperty("englishName") String name,
            final Planet satelliteOf,
            final @JsonProperty("sideralOrbit") double orbitalPeriodInDays,
            final @JsonProperty("sideralRotation") double sideralRotationInDays,
            final @JsonProperty("equaRadius") double equatorialRadiusInKm,
            final @JsonProperty("density") double density,
            final @JsonProperty("gravity") double gravity
    ) {
        super.name = name;
        this.satelliteOf = satelliteOf;
        this.equatorialDiameterInKm = equatorialRadiusInKm * 2;
        this.orbitalPeriodInDays = orbitalPeriodInDays;
        this.sideralRotationInDays = sideralRotationInDays;
        this.density = density;
        this.gravity = gravity;
    }

    @JsonProperty("orbitalPeriodInDays")
    public double getOrbitalPeriodInDays() {
        return orbitalPeriodInDays;
    }

    @JsonProperty("equatorialDiameterInKm")
    public double getEquatorialDiameterInKm() {
        return equatorialDiameterInKm;
    }

    @JsonProperty("sideralRotationInDays")
    public double getSideralRotationInDays() {
        return sideralRotationInDays;
    }

}
