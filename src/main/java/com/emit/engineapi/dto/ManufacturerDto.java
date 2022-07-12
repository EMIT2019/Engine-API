package com.emit.engineapi.dto;

import lombok.Data;

@Data
public class ManufacturerDto implements DtoEntity {
	private Long idMnufacturer;
	private String name; 
}
