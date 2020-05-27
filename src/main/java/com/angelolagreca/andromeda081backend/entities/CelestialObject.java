package com.angelolagreca.andromeda081backend.entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CelestialObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(unique = true)
    String name;

    @Override
    public String toString() {
        return  name ;
    }

}
