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

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private Integer codigoPostal;

    @Column(nullable = false)
    private boolean activo = true;
    @ManyToOne
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;
}
