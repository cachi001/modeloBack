package org.emiliano.elbuensaborback.dto;

import org.emiliano.elbuensaborback.entity.UnidadMedida;

public record ArticuloInsumoBaseResponse(
        Long id,
        String denominacion,
        UnidadMedida unidadMedida
) {

}
