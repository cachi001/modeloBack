package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T, ID> implements BaseService<T, ID>{

    protected final BaseRepository<T, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<T, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public T save(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public T update(T entity, ID id) {
        if (!baseRepository.existsById(id)) {
            throw new RuntimeException("No se encontró la entidad con ID: " + id);
        }
        return baseRepository.save(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return baseRepository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }
}
