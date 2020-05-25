package com.angelolagreca.andromeda081backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Planet")
@Setter
@Getter
@NoArgsConstructor
public class Planet extends CelestialObject implements SolarSystemObject {

    private int orderToSun;
    @OneToMany
    private Collection<Moons> moons;

    public Planet(final UUID id, final String name, final int orderToSun, final Collection<Moons> moons) {
        this.id = id;
        this.name = name;
        this.orderToSun = orderToSun;
        this.moons = moons;
    }

}
