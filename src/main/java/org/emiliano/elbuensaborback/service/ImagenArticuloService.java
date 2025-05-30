package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.ImagenArticulo;
import org.emiliano.elbuensaborback.repository.ImagenArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenArticuloService extends BaseServiceImpl<ImagenArticulo, Long>{

    public ImagenArticuloService(ImagenArticuloRepository imagenArticuloRepository)
    {
        super(imagenArticuloRepository);
    }

    @Override
    public ImagenArticulo save(ImagenArticulo entity) {
        return super.save(entity);
    }

    @Override
    public ImagenArticulo update(ImagenArticulo entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<ImagenArticulo> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<ImagenArticulo> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
