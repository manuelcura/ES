package com.artifact.es.repository;

import com.artifact.es.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
    @Query(value = "SELECT name from cities;", nativeQuery = true)
    List<String> findAllDistinctCities();
}
