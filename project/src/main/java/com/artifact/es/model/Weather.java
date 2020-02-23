package com.artifact.es.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    int id;
    String main;
    String description;
    String icon;
}
