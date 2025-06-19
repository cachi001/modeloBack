package org.emiliano.elbuensaborback.dto;

import lombok.*;
import org.emiliano.elbuensaborback.entity.Categoria;
import org.emiliano.elbuensaborback.entity.UnidadMedida;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloInsumoFullResponse {
    private Long id;
    private String denominacion;
    private Double precioCompra;
    private Double precioVenta;
    private Double stockActual;
    private Double stockMaximo;
    private Boolean esParaElaborar;
    private Boolean stockNegativo;
    private Boolean activo;
    private Categoria categoria;
    private UnidadMedida unidadMedida;
}
