package org.emiliano.elbuensaborback.model;

import jakarta.persistence.*;
import lombok.*;

import org.emiliano.elbuensaborback.model.enums.Estado;
import org.emiliano.elbuensaborback.model.enums.FormaDePago;
import org.emiliano.elbuensaborback.model.enums.TipoEnvio;

import java.time.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;

    @Enumerated(EnumType.STRING)
    private Estado estadoPedido;

    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @Enumerated(EnumType.STRING)
    private FormaDePago formaDePago;

    private LocalDate fechaPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detallePedidos;

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
