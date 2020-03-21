package com.artifact.es.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "weather")
@ApiModel(value="WeatherResponse", description="Weather for a specific city")
public class WeatherResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;
    @Column
    @ApiModelProperty(value = "City name")
    String city;
    @Column
    @ApiModelProperty(value = "Temperature ºC (Celsius)")
    double temp;
    @Column
    @ApiModelProperty(value = "Minimum temperature ºC (Celsius)")
    double tempMin;
    @Column
    @ApiModelProperty(value = "Maximum temperature ºC (Celsius)")
    double tempMax;
    @Column
    @ApiModelProperty(value = "Weather description")
    String description;
    @Column
    @ApiModelProperty(value = "Current request date")
    String currentRequestDate;
}
