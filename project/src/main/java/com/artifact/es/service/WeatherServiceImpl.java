package com.artifact.es.service;

import com.artifact.es.contants.Constants;
import com.artifact.es.model.Artifact;
import com.artifact.es.model.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    RestTemplate template = new RestTemplate();

    public WeatherResponse getCityWheather(String cityName) {
        Artifact artifact = sendWheatherRequest(cityName);
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setCity(artifact.getCity().getName());
        weatherResponse.setTemp(artifact.getList().get(0).getMain().getTemp());
        weatherResponse.setTempMin(artifact.getList().get(0).getMain().getTemp_min());
        weatherResponse.setTempMax(artifact.getList().get(0).getMain().getTemp_max());
        weatherResponse.setDescription(artifact.getList().get(0).getWeather().get(0).getDescription());
        return weatherResponse;
    }

    private Artifact sendWheatherRequest(String cityName) {
        String url = "http://api.openweathermap.org/data/2.5/forecast?q={city},pt&cnt=1&APPID={key}";

        ObjectMapper objectMapper = new ObjectMapper();

        return template.getForObject(url, Artifact.class, cityName, Constants.WHEATHER_API_KEY);

        // Can be used to filter information inside the JSON, there is no need to retrieve all
        // JsonNode jsonNode = objectMapper.readTree(json);
        // String color = jsonNode.get("color").asText();
    }
}
