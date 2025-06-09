package org.emiliano.elbuensaborback.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequest {
    private String denominacion;
    private Long categoriaPadreId;
}
