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
public class ImagenUsuario extends Imagen{

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
