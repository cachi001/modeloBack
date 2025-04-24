package org.emiliano.elbuensaborback.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;

    @OneToOne
    @JoinColumn(name = "tipo_promocion_id")
    private TipoPromocion tipoPromocion;

    @OneToMany(mappedBy = "promocion")
    private List<Imagen> imagenes;

    @ManyToMany
    @JoinTable(
            name = "promocion_sucursal",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "sucursal_id")
    )
    private List<Sucursal> sucursales;
}
