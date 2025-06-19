package org.emiliano.elbuensaborback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.emiliano.elbuensaborback.entity.ArticuloManufacturadoDetalle;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManufacturadoRequest {
    private String denominacion;
    private String descripcion;
    private BigDecimal precioVenta;
    private Integer tiempoEstimado;
    private String preparacion;
    private UnidadMedidaRequest unidadMedida;
    private CategoriaRequest categoria;
    private List<ImagenArticuloRequest> imagenes;
    private List<ArticuloManufacturadoDetalleRequest> articuloManufacturadoDetalles;
}
