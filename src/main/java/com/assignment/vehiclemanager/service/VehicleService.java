package com.assignment.vehiclemanager.service;

import com.assignment.vehiclemanager.dto.request.AddVehicleDTO;
import com.assignment.vehiclemanager.dto.request.UpdateVehicleDTO;
import com.assignment.vehiclemanager.dto.response.VehicleDTO;
import com.assignment.vehiclemanager.dto.response.VehicleListDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehicleService {
    VehicleListDTO getVehicles(Pageable pageable);
    void addVehicle(AddVehicleDTO addVehicleDTO) throws Exception;

    void updateVehicle(String inventoryCode, UpdateVehicleDTO updateVehicleDTO) throws Exception;

    void deleteVehicle(String inventoryCode) throws Exception;
}
