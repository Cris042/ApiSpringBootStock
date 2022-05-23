package com.api.parkingcontrol.modules.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.api.parkingcontrol.modules.parking.entities.ParkingSpotEntities;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotEntities, UUID> {

    boolean existsByLicensePlateCar(String licensePlateCar);
    boolean existsByParkingSpotNumber(String parkingSpotNumber);
    boolean existsByApartmentAndBlock(String apartment, String block);
}
