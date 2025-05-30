package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.TipoPromocion;
import org.emiliano.elbuensaborback.repository.TipoPromocionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPromocionService extends BaseServiceImpl<TipoPromocion, Long>{

    public TipoPromocionService(TipoPromocionRepository tipoPromocionRepository)
    {
        super(tipoPromocionRepository);
    }

    @Override
    public TipoPromocion save(TipoPromocion entity) {
        return super.save(entity);
    }

    @Override
    public TipoPromocion update(TipoPromocion entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<TipoPromocion> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<TipoPromocion> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
