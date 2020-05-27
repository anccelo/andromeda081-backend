package com.angelolagreca.andromeda081backend.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planet")
@Setter
@Getter
@NoArgsConstructor
public class Planet extends CelestialObject implements SolarSystemObject {

    private int orderToSun;

    public Planet(final Long id, final String name, final int orderToSun) {
        this.id = id;
        this.name = name;
        this.orderToSun = orderToSun;

    }

}
