package com.assignment.vehiclemanager.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VehicleDTO {
    @JsonProperty("inventory_code")
    private String inventoryCode;
    private String name;
    private String model;
    private String color;
}
