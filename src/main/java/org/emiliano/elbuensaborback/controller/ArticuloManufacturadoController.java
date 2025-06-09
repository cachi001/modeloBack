package org.emiliano.elbuensaborback.controller;

import org.emiliano.elbuensaborback.entity.ArticuloManufacturado;
import org.emiliano.elbuensaborback.repository.ArticuloManufacturadoRepository;
import org.emiliano.elbuensaborback.service.ArticuloManufacturadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articulo-manufacturado")
public class ArticuloManufacturadoController {

    private ArticuloManufacturadoService articuloManufacturadoService;

    public ArticuloManufacturadoController (ArticuloManufacturadoService articuloManufacturadoService){
        this.articuloManufacturadoService = articuloManufacturadoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticuloManufacturado>> obetenerArticulosManufacturados(){
        try {
            List<ArticuloManufacturado> listaArticuloManufacturado = articuloManufacturadoService.findAll();
            return ResponseEntity.ok(listaArticuloManufacturado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
