package org.emiliano.elbuensaborback.mapper;

import org.emiliano.elbuensaborback.dto.UnidadMedidaDto;
import org.emiliano.elbuensaborback.entity.UnidadMedida;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnidadMedidaMapper {

    UnidadMedida toEntity(UnidadMedidaDto unidadMedidaDto);
    UnidadMedidaDto toDto (UnidadMedida unidadMedida);
}
