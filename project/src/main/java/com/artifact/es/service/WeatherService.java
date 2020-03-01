package com.artifact.es.service;

import com.artifact.es.model.WeatherResponse;

import java.util.List;

public interface WeatherService {
    public WeatherResponse getCityWeather(String cityName);
    public List<WeatherResponse> getCityWeatherHistory(String cityName);
}
