package com.assignment.vehiclemanager.repository;

import com.assignment.vehiclemanager.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    Optional<Vehicle> findByInventoryCode(String inventoryCode);
}
