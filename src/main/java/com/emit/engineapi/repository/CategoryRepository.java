package com.emit.engineapi.repository;

import org.springframework.stereotype.Repository;

import com.emit.engineapi.model.Category;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {

}
