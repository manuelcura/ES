package com.artifact.es.controller;


import com.artifact.es.model.WeatherResponse;
import com.artifact.es.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/weather")
@Api(value = "Rest to retrieve weather information")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    private static final Logger LOG = LoggerFactory.getLogger(WeatherController.class);


    @GetMapping("/search/{city}")
    @CrossOrigin
    @ApiOperation(value = "Retrieve the current weather by city name", response = WeatherResponse.class)
    public ResponseEntity<WeatherResponse> getWheather(@PathVariable String city) {
        LOG.debug("Requesting weather for city: " + city);
        WeatherResponse weatherResponse = weatherService.getCityWeather(city);
        return new ResponseEntity<WeatherResponse>(weatherResponse, HttpStatus.OK);
    }

    @GetMapping("/search/history/{city}")
    @CrossOrigin
    @ApiOperation(value = "Retrieve the current weather by city name", response = List.class)
    public ResponseEntity<List<WeatherResponse>> getWeatherHistoryByCity(@PathVariable String city) {
        LOG.debug("Requesting weather history for city: " + city);
        List<WeatherResponse> weatherResponse = weatherService.getCityWeatherHistory(city);
        return new ResponseEntity<List<WeatherResponse>>(weatherResponse, HttpStatus.OK);
    }
}
