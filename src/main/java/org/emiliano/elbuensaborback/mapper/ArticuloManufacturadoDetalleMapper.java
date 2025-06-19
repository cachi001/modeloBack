package org.emiliano.elbuensaborback.mapper;

import org.emiliano.elbuensaborback.dto.ArticuloInsumoBaseResponse;
import org.emiliano.elbuensaborback.dto.ArticuloManufacturadoDetalleRequest;
import org.emiliano.elbuensaborback.entity.ArticuloInsumo;
import org.emiliano.elbuensaborback.entity.ArticuloManufacturadoDetalle;
import org.emiliano.elbuensaborback.repository.ArticuloInsumoRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {ArticuloInsumoMapper.class})
public abstract class ArticuloManufacturadoDetalleMapper {

    @Autowired
    protected ArticuloInsumoRepository articuloInsumoRepository;

    public List<ArticuloManufacturadoDetalle> toEntityList(List<ArticuloManufacturadoDetalleRequest> requestList) {
        List<ArticuloManufacturadoDetalle> detalles = new ArrayList<>();
        if (requestList != null) {
            for (ArticuloManufacturadoDetalleRequest req : requestList) {
                Long insumoId = req.articuloInsumo().id();
                ArticuloInsumo insumoCompleto = articuloInsumoRepository.findById(insumoId)
                        .orElseThrow(() -> new RuntimeException("Insumo no encontrado con ID: " + insumoId));
                ArticuloManufacturadoDetalle detalle = new ArticuloManufacturadoDetalle();
                detalle.setCantidad(req.cantidad());
                detalle.setArticuloInsumo(insumoCompleto);
                detalles.add(detalle);
            }
        }
        return detalles;
    }

}

