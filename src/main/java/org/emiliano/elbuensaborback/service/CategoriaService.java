package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Categoria;
import org.emiliano.elbuensaborback.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService extends BaseServiceImpl<Categoria, Long>{
    private final CategoriaRepository categoriaRepository;
    public CategoriaService(CategoriaRepository categoriaRepository) {
        super(categoriaRepository);
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria save(Categoria entity) {
        return super.save(entity);
    }

    @Override
    public Categoria update(Categoria entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<Categoria> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Categoria> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
    public List<Categoria> findByCategoriaPadreId(Long padreId) {
        return categoriaRepository.findByCategoriaPadreId(padreId);
    }
    public Categoria findByCategoria(String denominacion){
        Categoria categoria = categoriaRepository.findByDenominacion(denominacion)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        return categoria;
    }
}
