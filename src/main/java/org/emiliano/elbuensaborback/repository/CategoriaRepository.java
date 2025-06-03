package org.emiliano.elbuensaborback.repository;

import org.emiliano.elbuensaborback.entity.ArticuloInsumo;
import org.emiliano.elbuensaborback.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends BaseRepository<Categoria, Long>{
    List<Categoria> findByCategoriaPadreId(Long categoriaPadreId);
    Optional<Categoria> findByDenominacion (String denominacion);
}
