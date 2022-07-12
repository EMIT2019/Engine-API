package com.emit.engineapi.service.impl;

import com.emit.engineapi.model.Category;
import com.emit.engineapi.repository.CategoryRepository;
import com.emit.engineapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository cRepository; 
	
	@Override
	public List<Category> getAll() {
		return cRepository.findAll();
	}

	@Override
	public Category getById(Long ID) {
		Optional<Category> category = cRepository.findById(ID);
		if(category.isPresent()) {
			return category.get();
		}
		throw new RuntimeException("The category with the id "+ID+" does not exists");
	}

	@Override
	public Category save(Category item) {
		return cRepository.save(item);
	}

	@Override
	public Category update(Category item) {
		return cRepository.save(item);
	}

	@Override
	public void delete(Long ID) {
		cRepository.deleteById(ID);
	}

	@Override
	public List<Category> getPage(int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return cRepository.findAll(page).getContent();
	}

}
