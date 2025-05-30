package org.emiliano.elbuensaborback.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private Integer numero;
    private Integer codigoPostal;

    @ManyToOne
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;
}
