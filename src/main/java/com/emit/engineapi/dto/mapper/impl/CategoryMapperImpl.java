package com.emit.engineapi.dto.mapper.impl;

import com.emit.engineapi.dto.CategoryDto;
import com.emit.engineapi.dto.mapper.CategoryMapper;
import com.emit.engineapi.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {

	@Override
	public CategoryDto toDto(Category entity) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setIdCategory(entity.getIdCategory());
		categoryDto.setName(entity.getName());
		return categoryDto;
	}

	@Override
	public Category toEntity(CategoryDto dto) {
		Category category = new Category();
		category.setIdCategory(dto.getIdCategory());
		category.setName(dto.getName());
		return category;
	}

}
