package org.emiliano.elbuensaborback.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String auth0id;

    @Column(nullable = false)
    private String username;

    @Builder.Default
    @Column(nullable = false)
    private Boolean activo = true;
}
