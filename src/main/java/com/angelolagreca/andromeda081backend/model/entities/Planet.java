package com.angelolagreca.andromeda081backend.model.entities;

import com.angelolagreca.andromeda081backend.model.CelestialObject;
import com.angelolagreca.andromeda081backend.model.SolarSystemObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planet")
@Getter
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "orderToSun", "perihelionInKm", "aphelionInkm", "averageDistanceInkm",
        "orbitalPeriodInDays", "equatorialDiameterInKm", "gasPlanet"})
public class Planet extends CelestialObject implements SolarSystemObject {

    private int orderToSun; //todo: find a best set method
    private double perihelionInKm;
    private double aphelionInkm;
    private double averageDistanceInkm;
    private double orbitalVelocityInKmPerSec;
    private double orbitalPeriodInDays;
    private double orbitalLenghtInKm;
    private double equatorialDiameterInKm;
    private int noumberOfMoons;
    //ToDo i cant add collection of moons, i have a error if I do this :
    //Collection<Moons> moonsCollection;
    boolean isGasPlanet; //todo: find a best set method


    public Planet(
            final @JsonProperty("englishName") String name,
            final @JsonProperty("perihelion") double perihelionInKm,
            final @JsonProperty("aphelion") double aphelionInkm,
            // final @JsonProperty("") double orbitalVelocityInKmperSec,
            final @JsonProperty("sideralOrbit") double orbitalPeriodInDays,
            //final @JsonProperty("employee_id") double orbitalLenghtInKm,
            final @JsonProperty("equaRadius") double equatorialRadiusInKm
            //final @JsonProperty("employee_id") int noumberOfMoons,
            /* final @JsonProperty boolean isGasPlanet*/) {
        super.name = name;
        this.perihelionInKm = perihelionInKm;
        this.aphelionInkm = aphelionInkm;
        this.averageDistanceInkm = (aphelionInkm + perihelionInKm) / 2;
        // this.OrbitalVelocityInKmPerSec = orbitalVelocityInKmperSec;
        this.orbitalPeriodInDays = orbitalPeriodInDays;
        // this.OrbitalLenghtInKm = orbitalLenghtInKm;
        this.equatorialDiameterInKm = equatorialRadiusInKm * 2;
        // this.noumberOfMoons = noumberOfMoons;
        // this.isGasPlanet = isGasPlanet;
        setOrderToSunAndGasPlanetProperty();
    }

    @JsonProperty("perihelionInKm")
    public double getPerihelionInKm() {
        return perihelionInKm;
    }

    @JsonProperty("aphelionInkm")
    public double getAphelionInkm() {
        return aphelionInkm;
    }

    @JsonProperty("orbitalPeriodInDays")
    public double getOrbitalPeriodInDays() {
        return orbitalPeriodInDays;
    }

    @JsonProperty("equatorialDiameterInKm")
    public double getEquatorialDiameterInKm() {
        return equatorialDiameterInKm;
    }

    public void setOrderToSunAndGasPlanetProperty() {
        switch (name.toLowerCase()) {
            case "mercury":
                this.orderToSun = 1;
                break;
            case "venus":
                this.orderToSun = 2;
                break;
            case "earth":
                this.orderToSun = 3;
                break;
            case "mars":
                this.orderToSun = 4;
                break;
            case "jupiter":
                this.orderToSun = 5;
                this.isGasPlanet = true;
                break;
            case "saturn":
                this.orderToSun = 6;
                this.isGasPlanet = true;
                break;
            case "uranus":
                this.orderToSun = 7;
                this.isGasPlanet = true;
                break;
            case "neptune":
                this.orderToSun = 8;
                this.isGasPlanet = true;
                break;
            default:
                this.orderToSun = 0;
        }
    }

}
