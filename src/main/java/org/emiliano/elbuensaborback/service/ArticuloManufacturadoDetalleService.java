package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.ArticuloManufacturadoDetalle;
import org.emiliano.elbuensaborback.repository.ArticuloManufacturadoDetalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloManufacturadoDetalleService extends BaseServiceImpl<ArticuloManufacturadoDetalle, Long> {

    public ArticuloManufacturadoDetalleService(ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository){
        super(articuloManufacturadoDetalleRepository);
    }

    @Override
    public ArticuloManufacturadoDetalle save(ArticuloManufacturadoDetalle entity) {
        return super.save(entity);
    }

    @Override
    public ArticuloManufacturadoDetalle update(ArticuloManufacturadoDetalle entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<ArticuloManufacturadoDetalle> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<ArticuloManufacturadoDetalle> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
