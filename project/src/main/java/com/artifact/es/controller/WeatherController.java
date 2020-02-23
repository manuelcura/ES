package com.artifact.es.controller;


import com.artifact.es.model.WeatherResponse;
import com.artifact.es.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/weather")
@Api(value = "Rest to retrieve weather information")
@Log
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/search/{city}")
    @CrossOrigin
    @ApiOperation(value = "Retrieve the current weather by city name", response = WeatherResponse.class)
    public ResponseEntity<WeatherResponse> getWheather(@PathVariable String city) {

        WeatherResponse weatherResponse = weatherService.getCityWheather(city);
        return new ResponseEntity<WeatherResponse>(weatherResponse, HttpStatus.OK);
    }
}
