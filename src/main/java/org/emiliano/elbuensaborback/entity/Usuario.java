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

    @Column(nullable = false)
    private boolean activo = true;
}
