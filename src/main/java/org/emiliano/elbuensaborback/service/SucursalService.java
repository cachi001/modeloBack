package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Sucursal;
import org.emiliano.elbuensaborback.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService extends BaseServiceImpl<Sucursal, Long>{

    public SucursalService(SucursalRepository sucursalRepository)
    {
        super(sucursalRepository);
    }

    @Override
    public Sucursal save(Sucursal entity) {
        return super.save(entity);
    }

    @Override
    public Sucursal update(Sucursal entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<Sucursal> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Sucursal> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
