package com.artifact.es.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Artifact {
    int cod;
    int message;
    int cnt;
    List<WeatherSpecification> list;
    City city;
}
