package com.emit.engineapi.repository;

import org.springframework.stereotype.Repository;

import com.emit.engineapi.model.Vehicle;

@Repository
public interface VehicleRepository extends BaseRepository<Vehicle, Long> {

}
