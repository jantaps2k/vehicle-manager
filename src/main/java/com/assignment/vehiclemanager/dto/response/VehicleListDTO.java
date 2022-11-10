package com.assignment.vehiclemanager.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(name = "VehicleListDTO", description = "List of Vehicles Response")
@Data
public class VehicleListDTO {
    @Schema(description = "List of Vehicles")
    List<VehicleDTO> vehicles;

    @Schema(description = "Total Number of Records")
    private int total;
}
