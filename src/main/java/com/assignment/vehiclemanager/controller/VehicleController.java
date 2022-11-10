package com.assignment.vehiclemanager.controller;

import com.assignment.vehiclemanager.dto.request.AddVehicleDTO;
import com.assignment.vehiclemanager.dto.request.UpdateVehicleDTO;
import com.assignment.vehiclemanager.dto.response.VehicleDTO;
import com.assignment.vehiclemanager.dto.response.VehicleListDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

/**
 * @author jantaps2k
 */
@Tag(name = "Vehicle", description = "Vehicle API")
public interface VehicleController {
    @Operation(summary = "Vehicle List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    VehicleListDTO getVehicles(@PageableDefault(value = 2, page = 0) Pageable pageable);

    @Operation(summary = "Add Vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Vehicle is existing", content = @Content)
    })
    void addVehicle(@Parameter(description = "Vehicle to add") AddVehicleDTO addVehicleDTO) throws Exception;

    @Operation(summary = "Update Vehicle Details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Vehicle Not Found", content = @Content)
    })
    void updateVehicle(
            @Parameter(description = "Vehicle Id") String inventoryCode,
            @Parameter(description = "Vehicle details") UpdateVehicleDTO updateVehicleDTO) throws Exception;

    @Operation(summary = "Delete Vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Vehicle Not Found", content = @Content)
    })
    void deleteVehicle(@Parameter(description = "Vehicle Id") String inventoryCode) throws Exception;
}
