package org.emiliano.elbuensaborback.mapper;

import org.emiliano.elbuensaborback.dto.CategoriaDto;
import org.emiliano.elbuensaborback.dto.CategoriaDtoDenominacion;
import org.emiliano.elbuensaborback.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface  CategoriaMapper {
    Categoria toEntity (CategoriaDto categoriaDto);

    @Mapping(target = "categoriaPadreDenominacion", expression = "java(categoria.getCategoriaPadre() != null ? categoria.getCategoriaPadre().getDenominacion() : null)")
    CategoriaDtoDenominacion toDto(Categoria categoria);
}
