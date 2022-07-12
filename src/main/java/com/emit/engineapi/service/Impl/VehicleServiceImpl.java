package com.emit.engineapi.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.emit.engineapi.model.Vehicle;
import com.emit.engineapi.repository.VehicleRepository;
import com.emit.engineapi.service.VehicleService;

public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleRepository vRepository;
	
	@Override
	public List<Vehicle> getAll() {
		return vRepository.findAll();
	}

	@Override
	public Vehicle getById(Long ID) {
		Optional<Vehicle> vehicle = vRepository.findById(ID);
		if(vehicle.isPresent()) {
			return vehicle.get();
		}
		throw new RuntimeException("The vehicle with id "+ID+" does not exists");
	}

	@Override
	public Vehicle save(Vehicle item) {
		return vRepository.save(item);
	}

	@Override
	public Vehicle update(Vehicle item) {
		return vRepository.save(item);
	}

	@Override
	public void delete(Long ID) {
		vRepository.deleteById(ID);
	}

	@Override
	public List<Vehicle> getPage(int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return vRepository.findAll(page).getContent();
	}

}
