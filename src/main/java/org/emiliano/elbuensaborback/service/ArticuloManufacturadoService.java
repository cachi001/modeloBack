package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.ArticuloManufacturado;
import org.emiliano.elbuensaborback.repository.ArticuloManufacturadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloManufacturadoService extends BaseServiceImpl<ArticuloManufacturado, Long>{

    public ArticuloManufacturadoService(ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(articuloManufacturadoRepository);
    }

    @Override
    public ArticuloManufacturado save(ArticuloManufacturado entity) {
        return super.save(entity);
    }

    @Override
    public ArticuloManufacturado update(ArticuloManufacturado entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<ArticuloManufacturado> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<ArticuloManufacturado> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
