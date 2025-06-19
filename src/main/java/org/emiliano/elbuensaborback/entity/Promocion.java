package org.emiliano.elbuensaborback.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String denominacion;

    @Column(nullable = false)
    private LocalDate fechaDesde;

    @Column(nullable = false)
    private LocalDate fechaHasta;

    @Column(nullable = false)
    private LocalTime horaDesde;

    @Column(nullable = false)
    private LocalTime horaHasta;

    @Column(nullable = false)
    private String descripcionDescuento;

    @Column(nullable = false)
    private BigDecimal precioPromocional;

    @OneToOne
    @JoinColumn(name = "tipo_promocion_id")
    private TipoPromocion tipoPromocion;

    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "promocion_sucursal",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "sucursal_id")
    )
    private List<Sucursal> sucursales = new ArrayList<>();
}
