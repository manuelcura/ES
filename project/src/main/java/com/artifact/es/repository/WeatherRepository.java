package com.artifact.es.repository;

import com.artifact.es.model.WeatherResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherResponse, String> {
    List<WeatherResponse> findByCity(String city);
    List<WeatherResponse> findAll();
    void deleteById(String id);
}
