package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Ciudad;
import org.emiliano.elbuensaborback.repository.CiudadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService extends BaseServiceImpl<Ciudad, Long>{


    public CiudadService(CiudadRepository ciudadRepository) {
        super(ciudadRepository);
    }

    @Override
    public Ciudad save(Ciudad entity) {
        return super.save(entity);
    }

    @Override
    public Ciudad update(Ciudad entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<Ciudad> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Ciudad> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
