package org.emiliano.elbuensaborback.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.emiliano.elbuensaborback.model.enums.Rol;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
