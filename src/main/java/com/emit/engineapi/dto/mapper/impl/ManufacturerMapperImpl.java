package com.emit.engineapi.dto.mapper.impl;

import com.emit.engineapi.dto.ManufacturerDto;
import com.emit.engineapi.dto.mapper.ManufacturerMapper;
import com.emit.engineapi.model.Manufacturer;

public class ManufacturerMapperImpl implements ManufacturerMapper {

	@Override
	public ManufacturerDto toDto(Manufacturer entity) {
		ManufacturerDto manufacturerDto = new ManufacturerDto();
		manufacturerDto.setIdMnufacturer(entity.getIdManufacturer());
		manufacturerDto.setName(entity.getName());
		return manufacturerDto;
	}

	@Override
	public Manufacturer toEntity(ManufacturerDto dto) {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setIdManufacturer(dto.getIdMnufacturer());
		manufacturer.setName(dto.getName());
		return manufacturer;
	}

}
