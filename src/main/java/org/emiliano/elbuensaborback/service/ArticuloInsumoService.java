package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.ArticuloInsumo;
import org.emiliano.elbuensaborback.repository.ArticuloInsumoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloInsumoService extends BaseServiceImpl<ArticuloInsumo, Long>{


    public ArticuloInsumoService(ArticuloInsumoRepository articuloInsumoRepository) {
        super(articuloInsumoRepository);
    }

    @Override
    public ArticuloInsumo save(ArticuloInsumo entity) {
        return super.save(entity);
    }

    @Override
    public ArticuloInsumo update(ArticuloInsumo entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<ArticuloInsumo> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<ArticuloInsumo> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
