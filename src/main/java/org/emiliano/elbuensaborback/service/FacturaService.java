package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Factura;
import org.emiliano.elbuensaborback.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService extends BaseServiceImpl<Factura, Long>{

    public FacturaService(FacturaRepository facturaRepository)
    {
        super(facturaRepository);
    }

    @Override
    public Factura save(Factura entity) {
        return super.save(entity);
    }

    @Override
    public Factura update(Factura entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<Factura> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Factura> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
