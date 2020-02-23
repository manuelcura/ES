package com.artifact.es.service;

import com.artifact.es.model.WeatherResponse;

public interface WeatherService {
    public WeatherResponse getCityWheather(String cityName);
}
