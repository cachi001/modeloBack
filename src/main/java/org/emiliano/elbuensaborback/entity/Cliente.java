package org.emiliano.elbuensaborback.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "cliente_domicilio",
            joinColumns = @JoinColumn (name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "domicilio_id")
    )
    private List<Domicilio> domicilios = new ArrayList<>();
}
