package com.emit.engineapi.controller;

import com.emit.engineapi.dto.CategoryDto;
import com.emit.engineapi.dto.mapper.CategoryMapper;
import com.emit.engineapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/category")
@RestController
public class CategoryController {

    private CategoryService cService;

    private CategoryMapper mapper;

    @Autowired
    public CategoryController(CategoryService cService, CategoryMapper mapper) {
        this.cService = cService;
        this.mapper = mapper;
    }

    @GetMapping("/all-categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = cService.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/page-categories")
    public ResponseEntity<List<CategoryDto>> getPageCategories(@RequestParam("page") int pageNumber, @RequestParam("size") int pageSize) {
        List<CategoryDto> categories = cService.getPage(pageNumber, pageSize).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/get-category")
    public ResponseEntity<CategoryDto> getCategoryById(@RequestParam("idCategory") Long id) {
        return ResponseEntity.ok(mapper.toDto(cService.getById(id)));
    }

    @PostMapping("save-category")
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto) {
        cService.save(mapper.toEntity(categoryDto));
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.CREATED);
    }

    @PutMapping("/update-category")
    public ResponseEntity<CategoryDto> updateCategory(@RequestParam("idCategory") Long id, @RequestBody CategoryDto categoryDto) {
        categoryDto.setIdCategory(id);
        cService.update(mapper.toEntity(categoryDto));
        return ResponseEntity.ok(categoryDto);
    }

    @DeleteMapping("/delete-category")
    public ResponseEntity<HttpStatus> deleteCategory(@RequestParam("idCategory") Long id) {
        cService.delete(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
