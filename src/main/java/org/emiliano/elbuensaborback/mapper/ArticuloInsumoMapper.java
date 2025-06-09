package org.emiliano.elbuensaborback.mapper;

import org.emiliano.elbuensaborback.dto.ArticuloInsumoBaseResponse;
import org.emiliano.elbuensaborback.entity.ArticuloInsumo;
import org.mapstruct.*;
import org.mapstruct.ap.internal.util.accessor.AccessorType;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticuloInsumoMapper {

    default ArticuloInsumoBaseResponse toBaseResponse(ArticuloInsumo insumo) {
        if (insumo == null) {
            return null;
        }
        return new ArticuloInsumoBaseResponse(
                insumo.getId(),
                insumo.getDenominacion(),
                insumo.getUnidadMedida()
        );
    }

    List<ArticuloInsumoBaseResponse> toBaseResponseList(List<ArticuloInsumo> insumos);

}
