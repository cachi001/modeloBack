package org.emiliano.elbuensaborback.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nombre;

    private String razonSocial;

    private Integer cuit;

    @OneToMany(mappedBy = "empresa")
    private List<Sucursal> sucursales;
}
