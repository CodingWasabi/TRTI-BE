package com.codingwasabi.trti.domain.location.repository;

import com.codingwasabi.trti.domain.location.model.City;
import com.codingwasabi.trti.domain.location.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByCity(City city);
}
