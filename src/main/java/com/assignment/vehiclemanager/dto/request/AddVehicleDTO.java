package com.assignment.vehiclemanager.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AddVehicleDTO extends UpdateVehicleDTO {

    @JsonProperty("inventory_code")
    private String inventoryCode;

}
