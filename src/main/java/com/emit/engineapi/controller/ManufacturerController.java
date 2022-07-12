package com.emit.engineapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emit.engineapi.dto.ManufacturerDto;
import com.emit.engineapi.dto.mapper.ManufacturerMapper;
import com.emit.engineapi.dto.mapper.Impl.ManufacturerMapperImpl;
import com.emit.engineapi.service.ManufacturerService;

@RequestMapping("/manufacturer")
@RestController
public class ManufacturerController {
	@Autowired
	private ManufacturerService mService; 
	
	private ManufacturerMapper mapper = new ManufacturerMapperImpl();
	
	@GetMapping("/all-manufacturer")
	public ResponseEntity<List<ManufacturerDto>> getAllManufacturer(){
		List<ManufacturerDto> manufacturerList = mService.getAll().stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(manufacturerList);
	}
	
	@GetMapping("/manufacturer-page")
	public ResponseEntity<List<ManufacturerDto>> getManufacturerPage(@RequestParam("page") int pageNumber, @RequestParam("size") int pageSize){
		List<ManufacturerDto> manufacturerList = mService.getPage(pageNumber, pageSize).stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(manufacturerList);
	}
	
	@GetMapping("get-manufacturer")
	public ResponseEntity<ManufacturerDto> getManufacturerById(@RequestParam("idManufacturer") Long id){
		return ResponseEntity.ok(mapper.toDto(mService.getById(id)));
	}
	
	@PostMapping("/save-manufacturer")
	public ResponseEntity<ManufacturerDto> saveManufacturer(@RequestBody ManufacturerDto manufacturerDto){
		mService.save(mapper.toEntity(manufacturerDto));
		return new ResponseEntity<ManufacturerDto>(manufacturerDto, HttpStatus.CREATED);
	}
}
