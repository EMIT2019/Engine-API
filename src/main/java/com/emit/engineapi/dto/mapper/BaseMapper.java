package com.emit.engineapi.dto.mapper;

import com.emit.engineapi.dto.DtoEntity;
import com.emit.engineapi.model.ModelEntity;

public interface BaseMapper<T extends ModelEntity, E extends DtoEntity> {
	E toDto(T entity);
	
	T toEntity(E dto);
}
