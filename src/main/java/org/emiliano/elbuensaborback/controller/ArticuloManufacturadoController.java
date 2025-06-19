package org.emiliano.elbuensaborback.controller;

import org.emiliano.elbuensaborback.dto.ArticuloManufacturadoRequest;
import org.emiliano.elbuensaborback.entity.ArticuloInsumo;
import org.emiliano.elbuensaborback.entity.ArticuloManufacturado;
import org.emiliano.elbuensaborback.entity.ImagenArticulo;
import org.emiliano.elbuensaborback.mapper.ArticuloManufacturadoMapper;
import org.emiliano.elbuensaborback.repository.ArticuloInsumoRepository;
import org.emiliano.elbuensaborback.repository.ArticuloManufacturadoRepository;
import org.emiliano.elbuensaborback.service.ArticuloManufacturadoService;
import org.emiliano.elbuensaborback.service.CloudinaryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articulo-manufacturado")
public class ArticuloManufacturadoController {

    private final ArticuloManufacturadoService articuloManufacturadoService;
    private final CloudinaryService cloudinaryService;
    private final ArticuloManufacturadoMapper articuloManufacturadoMapper;

    public ArticuloManufacturadoController (ArticuloManufacturadoService articuloManufacturadoService,ArticuloManufacturadoMapper articuloManufacturadoMapper, CloudinaryService cloudinaryService){
        this.articuloManufacturadoService = articuloManufacturadoService;
        this.cloudinaryService = cloudinaryService;
        this.articuloManufacturadoMapper = articuloManufacturadoMapper;

    }
    @PostMapping(value = "/new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> crearArticulo(
            @RequestPart("datos") ArticuloManufacturadoRequest nuevo,
            @RequestPart(value = "imagenes", required = false) List<MultipartFile> imagenes
    ) {
        try {
            System.out.println("MANUFATCTURADO REQUEST " + nuevo.toString());
            // Crear entidad base desde DTO
            ArticuloManufacturado manufacturado = articuloManufacturadoMapper.toEntity(nuevo);

            // Si vienen imágenes, subirlas y asociarlas
            if (imagenes != null && !imagenes.isEmpty()) {
                List<ImagenArticulo> imagenesSubidas = new ArrayList<>();
                for (int i = 0; i < imagenes.size(); i++) {
                    MultipartFile file = imagenes.get(i);
                    String url = cloudinaryService.subirImagen(file);

                    ImagenArticulo imagen = ImagenArticulo.builder()
                            .urlImagen(url)
                            .denominacion(nuevo.getImagenes().get(i).getDenominacion())
                            .articulo(manufacturado)
                            .build();

                    imagenesSubidas.add(imagen);
                }

                manufacturado.setImagenes(imagenesSubidas);
            }

            // Guardar el manufacturado completo
            ArticuloManufacturado guardado = articuloManufacturadoService.save(manufacturado);
            System.out.println("MANUFACTURADO COMPLETO"+guardado.toString());
            return ResponseEntity.ok(guardado);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el artículo manufacturado: " + e.getMessage());
        }
    }

    // Actualizar un artículo manufacturado existente
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ArticuloManufacturado> actualizarArticulo(@PathVariable Long id, @RequestBody ArticuloManufacturado actualizado) {
        try {
            ArticuloManufacturado result = articuloManufacturadoService.update(actualizado, id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Eliminar un artículo manufacturado
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarArticulo(@PathVariable Long id) {
        try {
            articuloManufacturadoService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo eliminar el artículo: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticuloManufacturado>> obtenerArticulosManufacturados(){
        try {
            List<ArticuloManufacturado> listaArticuloManufacturado = articuloManufacturadoService.findAll();
            return ResponseEntity.ok(listaArticuloManufacturado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @PutMapping("/switch-state/{id}")
    public ResponseEntity<?> cambiarEstado(@PathVariable Long id) {
        try {
            System.out.println("CAMBIANDO ESTADO ARTICULO MANUFACTURADO");
            ArticuloManufacturado manufacturado = articuloManufacturadoService.cambiarEstadoManufacturado(id);
            return ResponseEntity.ok(manufacturado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al cambiar estado el insumo: " + e.getMessage());
        }
    }

}
