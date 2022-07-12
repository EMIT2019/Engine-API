package com.emit.engineapi.service.impl;

import com.emit.engineapi.model.Manufacturer;
import com.emit.engineapi.repository.ManufacturerRepository;
import com.emit.engineapi.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	
	@Autowired
	private ManufacturerRepository mRepository;
	
	@Override
	public List<Manufacturer> getAll() {
		return mRepository.findAll();
	}

	@Override
	public Manufacturer getById(Long ID) {
		Optional<Manufacturer> manufacturer = mRepository.findById(ID);
		if(manufacturer.isPresent()) {
			return manufacturer.get();
		}
		throw new RuntimeException("The manufacturer with id "+ID+" does not exists");
	}

	@Override
	public Manufacturer save(Manufacturer item) {
		return mRepository.save(item);
	}

	@Override
	public Manufacturer update(Manufacturer item) {
		return mRepository.save(item);
	}

	@Override
	public void delete(Long ID) {
		mRepository.deleteById(ID);
	}

	@Override
	public List<Manufacturer> getPage(int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return mRepository.findAll(page).getContent();
	}


}
