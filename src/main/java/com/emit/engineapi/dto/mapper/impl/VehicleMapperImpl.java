package com.emit.engineapi.dto.mapper.impl;

import com.emit.engineapi.dto.VehicleDto;
import com.emit.engineapi.dto.mapper.CategoryMapper;
import com.emit.engineapi.dto.mapper.ManufacturerMapper;
import com.emit.engineapi.dto.mapper.VehicleMapper;
import com.emit.engineapi.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapperImpl implements VehicleMapper {

    private ManufacturerMapper manufacturerMapper;
    private CategoryMapper categoryMapper;

    @Autowired
    VehicleMapperImpl(ManufacturerMapperImpl manufacturerMapper, CategoryMapper categoryMapper) {
        this.manufacturerMapper = manufacturerMapper;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public VehicleDto toDto(Vehicle entity) {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setIdVehicle(entity.getIdVehicle());
        vehicleDto.setManufacturer(manufacturerMapper.toDto(entity.getManufacturer()));
        vehicleDto.setCategory(categoryMapper.toDto(entity.getCategory()));
        vehicleDto.setHorsepower(entity.getHorsepower());
        vehicleDto.setTop_speed(entity.getTop_speed());
        vehicleDto.setImg(entity.getImg());
        vehicleDto.setModel(entity.getModel());
        return vehicleDto;
    }

    @Override
    public Vehicle toEntity(VehicleDto dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setIdVehicle(dto.getIdVehicle());
        vehicle.setManufacturer(manufacturerMapper.toEntity(dto.getManufacturer()));
        vehicle.setCategory(categoryMapper.toEntity(dto.getCategory()));
        vehicle.setHorsepower(dto.getHorsepower());
        vehicle.setTop_speed(dto.getTop_speed());
        vehicle.setImg(dto.getImg());
        vehicle.setModel(dto.getModel());
        return vehicle;
    }

}
