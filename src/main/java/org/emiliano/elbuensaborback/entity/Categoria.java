package org.emiliano.elbuensaborback.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;

    @Column(nullable = false)
    private boolean activo = true;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "categoria_padre_id")
    private Categoria categoriaPadre;

    @JsonManagedReference
    @Builder.Default
    @OneToMany(mappedBy = "categoriaPadre")
    private List<Categoria> subcategorias = new ArrayList<>();

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "categoria_sucursal",
            joinColumns = @JoinColumn(name = "categoria_id"),
            inverseJoinColumns = @JoinColumn(name = "sucursal_id")
    )
    private List<Sucursal> sucursales = new ArrayList<>();
}
