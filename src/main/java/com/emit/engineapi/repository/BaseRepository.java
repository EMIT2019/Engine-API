package com.emit.engineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.emit.engineapi.model.ModelEntity;

@NoRepositoryBean
public interface BaseRepository<T extends ModelEntity, ID> extends JpaRepository<T, ID> {

}
