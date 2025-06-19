package org.emiliano.elbuensaborback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private BigDecimal subtotal;

    @Column(nullable = false)
    private BigDecimal precioUnitario;

    @Column(nullable = false)
    private String denominacionArticulo;

    @ManyToOne()
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;
    @ManyToOne()
    @JoinColumn(name = "factura_id")
    private Factura factura;
}
