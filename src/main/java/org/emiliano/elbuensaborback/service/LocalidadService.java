package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Localidad;
import org.emiliano.elbuensaborback.repository.LocalidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadService extends BaseServiceImpl<Localidad, Long>{

    public LocalidadService(LocalidadRepository localidadRepository)
    {
        super(localidadRepository);
    }

    @Override
    public Localidad save(Localidad entity) {
        return super.save(entity);
    }

    @Override
    public Localidad update(Localidad entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<Localidad> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Localidad> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
