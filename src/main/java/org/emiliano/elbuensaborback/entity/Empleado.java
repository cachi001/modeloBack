package org.emiliano.elbuensaborback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.emiliano.elbuensaborback.entity.enums.Rol;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(value = EnumType.STRING)
    private Rol rol;

    @OneToOne()
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
