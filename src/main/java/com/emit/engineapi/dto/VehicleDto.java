package com.emit.engineapi.dto;

import lombok.Data;

@Data
public class VehicleDto implements DtoEntity {
	private Long idVehicle; 
	private ManufacturerDto manufacturer; 
	private CategoryDto category;
	private Long horsepower; 
	private Long top_speed; 
	private String img; 
	private String model; 
}
