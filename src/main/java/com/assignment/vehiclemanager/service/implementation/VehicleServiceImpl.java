package com.assignment.vehiclemanager.service.implementation;

import com.assignment.vehiclemanager.dto.request.AddVehicleDTO;
import com.assignment.vehiclemanager.dto.request.UpdateVehicleDTO;
import com.assignment.vehiclemanager.dto.response.VehicleDTO;
import com.assignment.vehiclemanager.dto.response.VehicleListDTO;
import com.assignment.vehiclemanager.model.Vehicle;
import com.assignment.vehiclemanager.repository.VehicleRepository;
import com.assignment.vehiclemanager.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleListDTO getVehicles(Pageable pageable) {
        log.info("Get all Vehicles");

        VehicleListDTO response = new VehicleListDTO();
        List<VehicleDTO> vehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepository.findAll(pageable)) {
            VehicleDTO vehicleDTO = new VehicleDTO();
            vehicleDTO.setInventoryCode(vehicle.getInventoryCode());
            vehicleDTO.setColor(vehicle.getColor());
            vehicleDTO.setName(vehicle.getName());
            vehicleDTO.setModel(vehicle.getModel());
            vehicles.add(vehicleDTO);
        }

        response.setVehicles(vehicles);
        response.setTotal(vehicles.size());
        return response;
    }

    public void addVehicle(AddVehicleDTO addVehicleDTO) throws Exception {
        log.info("Add new Vehicle");

        Optional<Vehicle> optionalVehicle = vehicleRepository.findByInventoryCode(addVehicleDTO.getInventoryCode());

        if (optionalVehicle.isPresent()) {
            throw new Exception("Vehicle is existing");
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setInventoryCode(addVehicleDTO.getInventoryCode());
        vehicle.setColor(addVehicleDTO.getColor());
        vehicle.setName(addVehicleDTO.getName());
        vehicle.setModel(addVehicleDTO.getModel());

        vehicleRepository.save(vehicle);
    }

    @Override
    public void updateVehicle(String inventoryCode, UpdateVehicleDTO updateVehicleDTO) throws Exception {
        log.info("Update Vehicle");
        Optional<Vehicle> optionalVehicle = vehicleRepository.findByInventoryCode(inventoryCode);

        if (optionalVehicle.isEmpty()) {
            throw new Exception("Vehicle Not Found");
        }

        Vehicle vehicle = optionalVehicle.get();
        vehicle.setModel(updateVehicleDTO.getModel());
        vehicle.setName(updateVehicleDTO.getName());
        vehicle.setColor(updateVehicleDTO.getColor());

        vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(String inventoryCode) throws Exception {
        log.info("Delete Vehicle");
        Optional<Vehicle> optionalVehicle = vehicleRepository.findByInventoryCode(inventoryCode);

        if (optionalVehicle.isEmpty()) {
            throw new Exception("Vehicle Not Found");
        }

        vehicleRepository.delete(optionalVehicle.get());
    }

}
