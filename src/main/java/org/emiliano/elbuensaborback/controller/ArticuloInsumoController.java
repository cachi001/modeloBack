package org.emiliano.elbuensaborback.controller;

import org.emiliano.elbuensaborback.dto.ArticuloInsumoDto;
import org.emiliano.elbuensaborback.entity.ArticuloInsumo;
import org.emiliano.elbuensaborback.repository.ArticuloInsumoRepository;
import org.emiliano.elbuensaborback.service.ArticuloInsumoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulo-insumo")
public class ArticuloInsumoController {

    private final ArticuloInsumoRepository articuloInsumoRepository;
    private final ArticuloInsumoService articuloInsumoService;

    public ArticuloInsumoController ( ArticuloInsumoRepository articuloInsumoRepository, ArticuloInsumoService articuloInsumoService) {
        this.articuloInsumoRepository = articuloInsumoRepository;
        this.articuloInsumoService = articuloInsumoService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearInsumo(@RequestBody ArticuloInsumoDto articuloInsumoDto) {
        try {
            System.out.println("CREANDO ARTICULO INSUMO");
            ArticuloInsumo nuevoInsumo = articuloInsumoService.crear(articuloInsumoDto);
            return ResponseEntity.ok(nuevoInsumo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el insumo: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticuloInsumo>> obtenerInsumos() {
        try {
            List<ArticuloInsumo> insumos = articuloInsumoService.listarTodos();
            return ResponseEntity.ok(insumos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerInsumoPorId(@PathVariable Long id) {
        try {
            ArticuloInsumo insumo = articuloInsumoService.obtenerPorId(id);
            if (insumo == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(insumo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener el insumo: " + e.getMessage());
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarInsumo(@PathVariable Long id, @RequestBody ArticuloInsumoDto articuloInsumoDto) {
        try {
            ArticuloInsumo actualizado = articuloInsumoService.actualizar(id, articuloInsumoDto);
            if (actualizado == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el insumo: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarInsumo(@PathVariable Long id) {
        try {
            boolean eliminado = articuloInsumoService.eliminar(id);
            if (!eliminado) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el insumo: " + e.getMessage());
        }
    }
}
