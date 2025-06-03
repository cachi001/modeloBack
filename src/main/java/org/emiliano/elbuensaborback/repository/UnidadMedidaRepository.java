package org.emiliano.elbuensaborback.repository;

import org.emiliano.elbuensaborback.entity.UnidadMedida;

import java.util.Optional;

public interface UnidadMedidaRepository extends BaseRepository<UnidadMedida, Long>{
    Optional<UnidadMedida> findByDenominacion (String denominacion);
}
