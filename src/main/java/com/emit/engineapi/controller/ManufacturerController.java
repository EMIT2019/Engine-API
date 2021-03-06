package com.emit.engineapi.controller;

import com.emit.engineapi.dto.ManufacturerDto;
import com.emit.engineapi.dto.mapper.ManufacturerMapper;
import com.emit.engineapi.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/manufacturer")
@RestController
public class ManufacturerController {

    private final ManufacturerService mService;

    private final ManufacturerMapper mapper;

    @Autowired
    public ManufacturerController(ManufacturerService mService, ManufacturerMapper mapper) {
        this.mService = mService;
        this.mapper = mapper;
    }

    @GetMapping("/all-manufacturer")
    public ResponseEntity<List<ManufacturerDto>> getAllManufacturer() {
        List<ManufacturerDto> manufacturerList = mService.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(manufacturerList);
    }

    @GetMapping("/manufacturer-page")
    public ResponseEntity<List<ManufacturerDto>> getManufacturerPage(@RequestParam("page") int pageNumber, @RequestParam("size") int pageSize) {
        List<ManufacturerDto> manufacturerList = mService.getPage(pageNumber, pageSize).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(manufacturerList);
    }

    @GetMapping("get-manufacturer")
    public ResponseEntity<ManufacturerDto> getManufacturerById(@RequestParam("idManufacturer") Long id) {
        return ResponseEntity.ok(mapper.toDto(mService.getById(id)));
    }

    @PostMapping("/save-manufacturer")
    public ResponseEntity<ManufacturerDto> saveManufacturer(@RequestBody ManufacturerDto manufacturerDto) {
        mService.save(mapper.toEntity(manufacturerDto));
        return new ResponseEntity<ManufacturerDto>(manufacturerDto, HttpStatus.CREATED);
    }

    @PutMapping("/update-manufacturer")
    public ResponseEntity<ManufacturerDto> updateManufacturer(@RequestParam("idManufacturer") Long id, @RequestBody ManufacturerDto manufacturerDto) {
        manufacturerDto.setIdMnufacturer(id);
        mService.update(mapper.toEntity(manufacturerDto));
        return ResponseEntity.ok(manufacturerDto);
    }

    @DeleteMapping("/delete-manufacturer")
    public ResponseEntity<HttpStatus> deleteManufacturerById(@RequestParam("idManufacturer") Long id) {
        mService.delete(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
