package com.artifact.es.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cities")
public class City {
    @Id
    int id;
    @Column
    String name;
    @Column
    String country;
    @Column
    int population;
    @Column
    int timezone;
    @Column
    long sunrise;
    @Column
    long sunset;
}
