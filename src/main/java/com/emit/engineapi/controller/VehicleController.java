package com.emit.engineapi.controller;

import com.emit.engineapi.dto.VehicleDto;
import com.emit.engineapi.dto.mapper.impl.VehicleMapperImpl;
import com.emit.engineapi.dto.mapper.VehicleMapper;
import com.emit.engineapi.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/vehicle")
@RestController
public class VehicleController {

    private VehicleService vService;

    private VehicleMapper mapper = new VehicleMapperImpl();

    @Autowired
    VehicleController(VehicleService vService) {
        this.vService = vService;
    }

    @GetMapping("/all-vehicles")
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        List<VehicleDto> vehicles = vService.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/vehicles-page")
    public ResponseEntity<List<VehicleDto>> getVehiclesPage(@RequestParam("page") int pageNumber, @RequestParam("size") int pageSize) {
        List<VehicleDto> pagedVehicles = vService.getPage(pageNumber, pageSize).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pagedVehicles);
    }

    @GetMapping("get-vehicles")
    public ResponseEntity<VehicleDto> getVehicleById(@RequestParam("idVehicle") Long id) {
        VehicleDto vehicle = mapper.toDto(vService.getById(id));
        return ResponseEntity.ok(vehicle);
    }


    @PostMapping("/save-vehicles")
    public ResponseEntity<VehicleDto> saveVehicle(@RequestBody VehicleDto vehicleDto) {
        vService.save(mapper.toEntity(vehicleDto));
        return new ResponseEntity<>(vehicleDto, HttpStatus.CREATED);
    }

    @PutMapping("/update-vehicles")
    public ResponseEntity<VehicleDto> updateVehicles(@RequestParam("idVehicle") Long id, @RequestBody VehicleDto vehicleDto) {
        vehicleDto.setIdVehicle(id);
        vService.update(mapper.toEntity(vehicleDto));
        return ResponseEntity.ok(vehicleDto);
    }

    @DeleteMapping("/delete-vehicles")
    public ResponseEntity<HttpStatus> deleteVehicleById(@RequestParam("idVehicle") Long id) {
        vService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
