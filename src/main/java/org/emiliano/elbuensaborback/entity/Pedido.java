package org.emiliano.elbuensaborback.entity;

import jakarta.persistence.*;
import lombok.*;

import org.emiliano.elbuensaborback.entity.enums.EstadoPedido;
import org.emiliano.elbuensaborback.entity.enums.FormaDePago;
import org.emiliano.elbuensaborback.entity.enums.TipoEnvio;

import java.math.BigDecimal;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalTime horaEstimadaFinalizacion;

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false)
    private BigDecimal totalCosto;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FormaDePago formaDePago;

    @Column(nullable = false)
    private LocalDate fechaPedido;

    @Builder.Default
    @Column(nullable = false)
    private Boolean activo = true;

    @Column(nullable = false)
    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "domicilio_id" )
    private Domicilio domicilio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
