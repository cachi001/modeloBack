package org.emiliano.elbuensaborback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleMercadoPago {
    @Column(name = "mp_id_pago", nullable = false)
    private Integer idPago;

    @Column(name = "mp_id_orden", nullable = false)
    private Integer idOrden;

    @Column(name = "mp_id_preferencia", nullable = false)
    private String idPreferencia;

    @Column(name = "mp_tipo_pago", nullable = false)
    private String tipoPago;
}
