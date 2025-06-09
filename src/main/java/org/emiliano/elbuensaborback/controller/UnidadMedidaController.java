package org.emiliano.elbuensaborback.controller;

import org.emiliano.elbuensaborback.entity.UnidadMedida;
import org.emiliano.elbuensaborback.service.UnidadMedidaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unidad-medida")
public class UnidadMedidaController {

    private final UnidadMedidaService unidadMedidaService;

    public UnidadMedidaController (
            UnidadMedidaService unidadMedidaService
    ){
        this.unidadMedidaService = unidadMedidaService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> obtenerUnidadesMedida (){
        try{
            System.out.println("OBTENIENDO UNIDADES DE MEDIDA");
            List<UnidadMedida> unidadMedidaList = unidadMedidaService.findAll();

            return ResponseEntity.ok(unidadMedidaList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
