package org.emiliano.elbuensaborback.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    T save(T entity);
    T update(T entity, ID id);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
}
