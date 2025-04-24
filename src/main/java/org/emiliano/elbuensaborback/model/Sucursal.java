package org.emiliano.elbuensaborback.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private LocalTime horaApertura;

    private LocalTime horaCierre;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToMany(mappedBy = "sucursales")
    private List<Promocion> promociones;

    @ManyToMany(mappedBy = "sucursales")
    private List<Categoria> categorias;
}
