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

    private LocalTime horaEstimadaFinalizacion;
    private BigDecimal total;
    private BigDecimal totalCosto;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @Enumerated(EnumType.STRING)
    private FormaDePago formaDePago;

    private LocalDate fechaPedido;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "domicilio_id" )
    private Domicilio domicilio;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
