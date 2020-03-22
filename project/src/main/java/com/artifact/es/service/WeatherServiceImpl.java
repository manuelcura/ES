package com.artifact.es.service;

import com.artifact.es.contants.Constants;
import com.artifact.es.controller.WeatherController;
import com.artifact.es.model.Artifact;
import com.artifact.es.model.WeatherResponse;
import com.artifact.es.repository.CityRepository;
import com.artifact.es.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private CityRepository cityRepository;

    private static final RestTemplate template = new RestTemplate();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSS");

    private static final Logger LOG = LoggerFactory.getLogger(WeatherServiceImpl.class);


    @Override
    public WeatherResponse getCityWeather(String cityName) {
        LOG.debug("Requesting temperature information for: " + cityName);
        Artifact artifact = sendWeatherRequest(cityName);
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setCity(artifact.getCity().getName());
        weatherResponse.setTemp(convertKelvinToCelsius(artifact.getList().get(0).getMain().getTemp()));
        weatherResponse.setTempMin(convertKelvinToCelsius(artifact.getList().get(0).getMain().getTemp_min()));
        weatherResponse.setTempMax(convertKelvinToCelsius(artifact.getList().get(0).getMain().getTemp_max()));
        weatherResponse.setDescription(artifact.getList().get(0).getWeather().get(0).getDescription());
        weatherResponse.setCurrentRequestDate(sdf.format(new Date()));
        weatherRepository.save(weatherResponse);
        LOG.debug("Persisting information: " + weatherResponse.toString());
        cityRepository.save(artifact.getCity());
        return weatherResponse;
    }

    @Override
    public List<WeatherResponse> getCityWeatherHistory(String cityName) {
        return weatherRepository.findByCity(cityName);
    }

    //@Scheduled(fixedRate = 10000)
    private void saveWeatherRequests() {
        LOG.debug("Scheduled activated");
        cityRepository.findAllDistinctCities().forEach(this::getCityWeather);
    }

    @Scheduled(fixedRate = 5000)
    private void imHere() {
        LOG.info("Scheduled activated: IM HERE!!!!");
        //cityRepository.findAllDistinctCities().forEach(this::getCityWeather);
    }

    private double convertKelvinToCelsius(double tempInKelvin) {
        return (tempInKelvin - 273.15);
    }

    private Artifact sendWeatherRequest(String cityName) {
        LOG.info("Requesting external weather API (openweathermap) for information: " + cityName);
        String url = "http://api.openweathermap.org/data/2.5/forecast?q={city},pt&cnt=1&APPID={key}";

        //ObjectMapper objectMapper = new ObjectMapper();

        return template.getForObject(url, Artifact.class, cityName, Constants.WHEATHER_API_KEY);

        // Can be used to filter information inside the JSON, there is no need to retrieve all
        // JsonNode jsonNode = objectMapper.readTree(json);
        // String color = jsonNode.get("color").asText();
    }


}
