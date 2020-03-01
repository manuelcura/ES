package com.artifact.es.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherSpecification {
    Main main;
    List<Weather> weather;
}
