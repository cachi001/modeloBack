package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Provincia;
import org.emiliano.elbuensaborback.repository.ProvinciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaService extends BaseServiceImpl<Provincia, Long>{

    public ProvinciaService(ProvinciaRepository provinciaRepository)
    {
        super(provinciaRepository);
    }

    @Override
    public Provincia save(Provincia entity) {
        return super.save(entity);
    }

    @Override
    public Provincia update(Provincia entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<Provincia> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Provincia> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
