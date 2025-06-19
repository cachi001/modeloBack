package org.emiliano.elbuensaborback.dto;

public record ArticuloManufacturadoDetalleRequest(
        Integer cantidad,
        ArticuloInsumoBaseResponse articuloInsumo
) {}
