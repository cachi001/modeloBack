package org.emiliano.elbuensaborback.mapper;

import org.emiliano.elbuensaborback.dto.CategoriaDto;
import org.emiliano.elbuensaborback.dto.CategoriaResponseDto;
import org.emiliano.elbuensaborback.dto.CategoriaPadreDto;
import org.emiliano.elbuensaborback.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {

    Categoria toEntity(CategoriaDto categoriaDto);

    @Mapping(source = "categoriaPadre", target = "categoriaPadre", qualifiedByName = "mapearPadre")
    CategoriaResponseDto toResponseDto(Categoria categoria);

    @Named("mapearPadre")
    default CategoriaPadreDto mapearPadre(Categoria categoriaPadre) {
        if (categoriaPadre == null) {
            return null;
        }
        return new CategoriaPadreDto(categoriaPadre.getId(), categoriaPadre.getDenominacion());
    }
}
