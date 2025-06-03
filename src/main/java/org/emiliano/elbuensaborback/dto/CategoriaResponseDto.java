package org.emiliano.elbuensaborback.dto;

public record CategoriaResponseDto(
        Long id,
        String denominacion,
        CategoriaPadreDto categoriaPadre
) {
}

