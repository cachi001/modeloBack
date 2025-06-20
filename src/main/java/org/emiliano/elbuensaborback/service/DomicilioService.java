package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Domicilio;
import org.emiliano.elbuensaborback.repository.DomicilioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService extends BaseServiceImpl<Domicilio, Long>{


    public DomicilioService(DomicilioRepository detalleRepository) {
        super(detalleRepository);
    }

    @Override
    public Domicilio save(Domicilio entity) {
        return super.save(entity);
    }

    @Override
    public Domicilio update(Domicilio entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<Domicilio> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Domicilio> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
