package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.DetalleFactura;
import org.emiliano.elbuensaborback.repository.DetalleFacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaService extends BaseServiceImpl<DetalleFactura, Long>{

    public DetalleFacturaService(DetalleFacturaRepository detalleFacturaRepository ) {
        super(detalleFacturaRepository);
    }

    @Override
    public DetalleFactura save(DetalleFactura entity) {
        return super.save(entity);
    }

    @Override
    public DetalleFactura update(DetalleFactura entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<DetalleFactura> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<DetalleFactura> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
