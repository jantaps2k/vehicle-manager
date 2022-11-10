package com.assignment.vehiclemanager.controller.implementation;

import com.assignment.vehiclemanager.controller.VehicleController;
import com.assignment.vehiclemanager.dto.request.AddVehicleDTO;
import com.assignment.vehiclemanager.dto.request.UpdateVehicleDTO;
import com.assignment.vehiclemanager.dto.response.VehicleListDTO;
import com.assignment.vehiclemanager.service.VehicleService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleControllerImpl implements VehicleController {
    private final VehicleService vehicleService;

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleListDTO getVehicles(@PageableDefault(value = 2, page = 0) Pageable pageable) {
        return vehicleService.getVehicles(pageable);
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addVehicle(@RequestBody AddVehicleDTO addVehicleDTO) throws Exception {
        vehicleService.addVehicle(addVehicleDTO);
    }

    @Override
    @PutMapping(
            value = "/{inventory_code}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateVehicle(
            @PathVariable("inventory_code") String inventoryCode,
            @RequestBody UpdateVehicleDTO updateVehicleDTO) throws Exception {
        vehicleService.updateVehicle(inventoryCode, updateVehicleDTO);
    }

    @Override
    @DeleteMapping(value = "/{inventory_code}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteVehicle(@PathVariable("inventory_code") String inventoryCode) throws Exception {
        vehicleService.deleteVehicle(inventoryCode);
    }
}
