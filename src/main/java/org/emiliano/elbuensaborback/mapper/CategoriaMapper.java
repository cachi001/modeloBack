package org.emiliano.elbuensaborback.mapper;

import org.emiliano.elbuensaborback.dto.CategoriaResponse;
import org.emiliano.elbuensaborback.dto.CategoriaPadreDto;
import org.emiliano.elbuensaborback.entity.Categoria;
import org.mapstruct.Mapper;

import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {

    default CategoriaResponse toResponseDto(Categoria categoria) {
        if (categoria == null) return null;

        CategoriaPadreDto padreDto = null;
        if (categoria.getCategoriaPadre() != null) {
            padreDto = new CategoriaPadreDto(
                    categoria.getCategoriaPadre().getId(),
                    categoria.getCategoriaPadre().getDenominacion()
            );
        }

        return new CategoriaResponse(
                categoria.getId(),
                categoria.getDenominacion(),
                padreDto
        );
    }
}


