package com.emit.engineapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emit.engineapi.dto.CategoryDto;
import com.emit.engineapi.dto.mapper.CategoryMapper;
import com.emit.engineapi.dto.mapper.impl.CategoryMapperImpl;
import com.emit.engineapi.service.CategoryService;

@RequestMapping("/category")
@RestController
public class CategoryController {
	@Autowired
	private CategoryService cService; 
	
	private CategoryMapper mapper = new CategoryMapperImpl();
	
	@GetMapping("/all-categories")
	public ResponseEntity<List<CategoryDto>> getAllCategories(){
		List<CategoryDto> categories = cService.getAll().stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(categories);
	}
	
	@GetMapping("/page-categories")
	public ResponseEntity<List<CategoryDto>> getPageCategories(@RequestParam("page") int pageNumber, @RequestParam("size") int pageSize){
		List<CategoryDto> categories = cService.getPage(pageNumber, pageSize).stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(categories);
	}
	
	@GetMapping("/get-category")
	public ResponseEntity<CategoryDto> getCategoryById(@RequestParam("idCategory") Long id){
		return ResponseEntity.ok(mapper.toDto(cService.getById(id)));
	}
	
	@PostMapping("save-category")
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto){
		cService.save(mapper.toEntity(categoryDto));
		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/update-category")
	public ResponseEntity<CategoryDto> updateCategory(@RequestParam("idCategory") Long id, @RequestBody CategoryDto categoryDto){
		categoryDto.setIdCategory(id);
		cService.update(mapper.toEntity(categoryDto));
		return ResponseEntity.ok(categoryDto);
	}
	
	@DeleteMapping("/delete-category")
	public ResponseEntity<HttpStatus> deleteCategory(@RequestParam("idCategory") Long id){
		cService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
