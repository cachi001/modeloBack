package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Promocion;
import org.emiliano.elbuensaborback.repository.PromocionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocionService extends BaseServiceImpl<Promocion, Long>{

    public PromocionService(PromocionRepository promocionRepository)
    {
        super(promocionRepository);
    }

    @Override
    public Promocion save(Promocion entity) {
        return super.save(entity);
    }

    @Override
    public Promocion update(Promocion entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<Promocion> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Promocion> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
