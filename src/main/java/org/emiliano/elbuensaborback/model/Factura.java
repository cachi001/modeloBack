package org.emiliano.elbuensaborback.model;

import jakarta.persistence.*;
import lombok.*;
import org.emiliano.elbuensaborback.model.enums.FormaDePago;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaFacturacion;
    private Integer mpPaymentId;
    private Integer mpMerchantOrderId;
    private String mpPreferenceId;
    private String mpPaymentType;

    @Enumerated(EnumType.STRING)
    private FormaDePago formaDePago;

    private Double totalVenta;

    @OneToOne(mappedBy = "factura")
    private Pedido pedido;
}
