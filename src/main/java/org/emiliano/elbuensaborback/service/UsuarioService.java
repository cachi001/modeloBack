package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Usuario;
import org.emiliano.elbuensaborback.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long>{

    public UsuarioService(UsuarioRepository usuarioRepository)
    {
        super(usuarioRepository);
    }

    @Override
    public Usuario save(Usuario entity) {
        return super.save(entity);
    }

    @Override
    public Usuario update(Usuario entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<Usuario> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
