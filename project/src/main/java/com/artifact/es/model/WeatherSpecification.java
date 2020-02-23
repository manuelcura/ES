package com.artifact.es.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherSpecification {
    long dt;
    Main main;
    List<Weather> weather;
    Clouds clouds;
    Wind wind;
    Sys sys;
    String dt_txt;
}
