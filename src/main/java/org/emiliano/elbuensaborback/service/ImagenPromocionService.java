package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.ImagenPromocion;
import org.emiliano.elbuensaborback.repository.ImagenPromocionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenPromocionService extends BaseServiceImpl<ImagenPromocion, Long>{

    public ImagenPromocionService(ImagenPromocionRepository imagenPromocionRepository) {
        super(imagenPromocionRepository);
    }

    @Override
    public ImagenPromocion save(ImagenPromocion entity) {
        return super.save(entity);
    }

    @Override
    public ImagenPromocion update(ImagenPromocion entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<ImagenPromocion> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<ImagenPromocion> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
