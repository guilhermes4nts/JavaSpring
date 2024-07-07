package com.guilherme.Place_Service.repositories;

import com.guilherme.Place_Service.models.PlaceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<PlaceModel, Long> {
}
