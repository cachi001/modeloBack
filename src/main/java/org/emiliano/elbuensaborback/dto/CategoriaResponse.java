package org.emiliano.elbuensaborback.dto;

public record CategoriaResponse(
        Long id,
        String denominacion,
        Boolean activo,
        CategoriaPadreDto categoriaPadre
) {
}

