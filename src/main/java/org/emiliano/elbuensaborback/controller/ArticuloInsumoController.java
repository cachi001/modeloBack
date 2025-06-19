package org.emiliano.elbuensaborback.controller;

import org.emiliano.elbuensaborback.dto.ArticuloInsumoBaseResponse;
import org.emiliano.elbuensaborback.dto.ArticuloInsumoRequest;
import org.emiliano.elbuensaborback.entity.ArticuloInsumo;
import org.emiliano.elbuensaborback.entity.ImagenArticulo;
import org.emiliano.elbuensaborback.mapper.ArticuloInsumoMapper;
import org.emiliano.elbuensaborback.repository.ArticuloInsumoRepository;
import org.emiliano.elbuensaborback.service.ArticuloInsumoService;
import org.emiliano.elbuensaborback.service.CloudinaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articulo-insumo")
public class ArticuloInsumoController {

    private final ArticuloInsumoService articuloInsumoService;
    private final ArticuloInsumoMapper articuloInsumoMapper;
    private final CloudinaryService cloudinaryService;

    public ArticuloInsumoController (
            ArticuloInsumoService articuloInsumoService,
            ArticuloInsumoMapper articuloInsumoMapper,
            CloudinaryService cloudinaryService
    ) {
        this.articuloInsumoService = articuloInsumoService;
        this.articuloInsumoMapper = articuloInsumoMapper;
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearInsumo(
            @RequestPart("datos") ArticuloInsumoRequest articuloInsumoDto,
            @RequestPart(value = "imagenes", required = false) List<MultipartFile> imagenes
    ) {
        try {
            ArticuloInsumo nuevoInsumo = articuloInsumoMapper.toEntity(articuloInsumoDto);

            if (imagenes != null && !imagenes.isEmpty()) {
                List<ImagenArticulo> imagenesSubidas = new ArrayList<>();
                for (int i = 0; i < imagenes.size(); i++) {
                    MultipartFile file = imagenes.get(i);
                    String url = cloudinaryService.subirImagen(file);

                    ImagenArticulo imagen = ImagenArticulo.builder()
                            .urlImagen(url)
                            .denominacion(articuloInsumoDto.getImagenes().get(i).getDenominacion())
                            .articulo(nuevoInsumo)
                            .build();
                    imagenesSubidas.add(imagen);
                }

                nuevoInsumo.setImagenes(imagenesSubidas);
            }

            ArticuloInsumo guardado = articuloInsumoService.save(nuevoInsumo);
            return ResponseEntity.ok(guardado);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el insumo: " + e.getMessage());
        }
    }


    @PutMapping("/switch-state/{id}")
    public ResponseEntity<?> cambiarEstado(@PathVariable Long id) {
        try {
            System.out.println("CAMBIANDO ESTADO ARTICULO INSUMO");
            ArticuloInsumo nuevoInsumo = articuloInsumoService.cambiarEstadoInsumo(id);
            return ResponseEntity.ok(nuevoInsumo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al cambiar estado el insumo: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticuloInsumo>> obtenerInsumos() {
        try {
            List<ArticuloInsumo> insumos = articuloInsumoService.findAll();
            return ResponseEntity.ok(insumos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/base/all")
    public ResponseEntity<List<ArticuloInsumoBaseResponse>> obtenerInsumosBase() {
        try {
            List<ArticuloInsumoBaseResponse> insumos = articuloInsumoService.obtenerInsumosBase();
            return ResponseEntity.ok(insumos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerInsumoPorId(@PathVariable Long id) {
        try {
            Optional<ArticuloInsumo>insumo = articuloInsumoService.findById(id);
            if (insumo.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(insumo.get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener el insumo: " + e.getMessage());
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarInsumo(@PathVariable Long id, @RequestBody ArticuloInsumoRequest articuloInsumoRequest) {
        try {
            ArticuloInsumo actualizado = articuloInsumoService.actualizar(articuloInsumoRequest, id );
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
            articuloInsumoService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el insumo: " + e.getMessage());
        }
    }
}
