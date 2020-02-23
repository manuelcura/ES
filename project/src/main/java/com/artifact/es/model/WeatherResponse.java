package com.artifact.es.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="WeatherResponse", description="Weather for a specific city")
public class WeatherResponse {
    @ApiModelProperty(value = "City name")
    String city;
    @ApiModelProperty(value = "Temperature ºF (Fahrenheit)")
    double temp;
    @ApiModelProperty(value = "Minimum temperature ºF (Fahrenheit)")
    double tempMin;
    @ApiModelProperty(value = "Maximum temperature ºF (Fahrenheit)")
    double tempMax;
    @ApiModelProperty(value = "Weather description")
    String description;
}
