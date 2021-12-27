package com.codingwasabi.trti.domain.location.repository;

import com.codingwasabi.trti.domain.location.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
