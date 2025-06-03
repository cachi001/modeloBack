package org.emiliano.elbuensaborback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.emiliano.elbuensaborback.entity.Articulo;
import org.emiliano.elbuensaborback.entity.ArticuloManufacturadoDetalle;
import org.emiliano.elbuensaborback.entity.UnidadMedida;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManufacturadoDto {
    private String denominacion;
    private String descripcion;
    private BigDecimal precioVenta;
    private Integer tiempoEstimado;
    private String preparacion;
    private UnidadMedidaDto unidadMedida;
    private CategoriaDto categoria;
    private List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles;
}
