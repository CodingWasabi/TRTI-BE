package com.codingwasabi.trti.domain.city.repository;

import com.codingwasabi.trti.domain.city.model.Location;
import com.codingwasabi.trti.domain.city.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByLocation(Location location);
}
