package com.emit.engineapi.dto;

import lombok.Data;

@Data
public class CategoryDto implements DtoEntity {
	private Long idCategory; 
	private String name; 
}
