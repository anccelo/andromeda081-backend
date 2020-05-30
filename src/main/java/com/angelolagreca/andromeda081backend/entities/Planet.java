package com.angelolagreca.andromeda081backend.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planet")
@Getter
@NoArgsConstructor
public class Planet extends CelestialObject implements SolarSystemObject {

    private int orderToSun;

    private double perihelionInkm;
    private double aphelionInkm;
    private double averageDistanceInkm;

    private double OrbitalVelocityInKmPerSec;
    private double OrbitalPeriodInDays;
    private double OrbitalLenghtInKm;

    private double EquatorialDiameterInKm;

    private int noumberOfMoons;

    boolean isGasPlanet;

    public Planet(final Long id, final String name, final int orderToSun) {
        super(id,name);
        this.orderToSun = orderToSun;
    }

    public Planet(final Long id,final String name, final double perihelionInkm,
                  final double aphelionInkm, final double averageDistanceInkm,
                  final double orbitalVelocityInKmperSec, final double orbitalPeriodInDays,
                  final double orbitalLenghtInKm, final double equatorialDiameterInKm,
                  final int noumberOfMoons, final boolean isGasPlanet) {
        super(id, name);
        this.perihelionInkm = perihelionInkm;
        this.aphelionInkm = aphelionInkm;
        this.averageDistanceInkm = averageDistanceInkm;
        this.OrbitalVelocityInKmPerSec = orbitalVelocityInKmperSec;
        this.OrbitalPeriodInDays = orbitalPeriodInDays;
        this.OrbitalLenghtInKm = orbitalLenghtInKm;
        this.EquatorialDiameterInKm = equatorialDiameterInKm;
        this.noumberOfMoons = noumberOfMoons;
        this.isGasPlanet = isGasPlanet;
    }
}
