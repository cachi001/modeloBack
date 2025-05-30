package org.emiliano.elbuensaborback.entity;

import jakarta.persistence.*;
import lombok.*;
import org.emiliano.elbuensaborback.entity.enums.EstadoPago;
import org.emiliano.elbuensaborback.entity.enums.FormaDePago;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaFacturacion;

    @Embedded
    private DetalleMercadoPago detalleMercadoPago;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoPago estadoPago;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FormaDePago formaDePago;

    @Column(nullable = false)
    private BigDecimal totalVenta;

    @Builder.Default
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalleFactura = new ArrayList<>();
}
