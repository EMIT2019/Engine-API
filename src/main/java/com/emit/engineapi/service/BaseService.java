package com.emit.engineapi.service;

import java.util.List;

public interface BaseService<T, ID> {
    List<T> getPage(int pageNumber, int pageSize);

    List<T> getAll();

    T getById(ID id);

    T save(T item);

    T update(T item);

    void delete(ID id);
}
