package com.artifact.es.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
    int id;
    String name;
    Coordinates coord;
    String country;
    int population;
    int timezone;
    long sunrise;
    long sunset;
}
