package org.emiliano.elbuensaborback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ImagenArticulo extends Imagen{

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

}
