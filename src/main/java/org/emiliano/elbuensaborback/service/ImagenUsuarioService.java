package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.ImagenUsuario;
import org.emiliano.elbuensaborback.repository.ImagenUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenUsuarioService extends BaseServiceImpl<ImagenUsuario, Long>{

    public ImagenUsuarioService(ImagenUsuarioRepository imagenUsuarioRepository) {
        super(imagenUsuarioRepository);
    }

    @Override
    public ImagenUsuario save(ImagenUsuario entity) {
        return super.save(entity);
    }

    @Override
    public ImagenUsuario update(ImagenUsuario entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<ImagenUsuario> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<ImagenUsuario> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
