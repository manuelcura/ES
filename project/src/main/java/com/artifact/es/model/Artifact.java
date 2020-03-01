package com.artifact.es.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Artifact {
    List<WeatherSpecification> list;
    City city;
}
