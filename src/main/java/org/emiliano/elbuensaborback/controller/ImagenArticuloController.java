package org.emiliano.elbuensaborback.controller;

import org.emiliano.elbuensaborback.entity.Articulo;
import org.emiliano.elbuensaborback.entity.ImagenArticulo;
import org.emiliano.elbuensaborback.service.ArticuloInsumoService;
import org.emiliano.elbuensaborback.service.ArticuloManufacturadoService;
import org.emiliano.elbuensaborback.service.CloudinaryService;
import org.emiliano.elbuensaborback.service.ImagenArticuloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imagenes/articulos")
public class ImagenArticuloController {

    private final CloudinaryService cloudinaryService;
    private final ImagenArticuloService imagenArticuloService;
    private final ArticuloInsumoService articuloInsumoService;
    private final ArticuloManufacturadoService articuloManufacturadoService;

    public ImagenArticuloController(CloudinaryService cloudinaryService,
                                    ImagenArticuloService imagenArticuloService,
                                    ArticuloInsumoService articuloInsumoService,
                                    ArticuloManufacturadoService articuloManufacturadoService) {
        this.cloudinaryService = cloudinaryService;
        this.imagenArticuloService = imagenArticuloService;
        this.articuloInsumoService = articuloInsumoService;
        this.articuloManufacturadoService = articuloManufacturadoService;
    }

    // CREAR
    @PostMapping("/subir")
    public ResponseEntity<ImagenArticulo> subirImagen(
            @RequestParam("file") MultipartFile file,
            @RequestParam("denominacion") String denominacion,
            @RequestParam("tipo") String tipo,
            @RequestParam("articuloId") Long articuloId) {

        if (file.isEmpty()) return ResponseEntity.badRequest().build();

        Optional<? extends Articulo> articuloOpt = buscarArticuloPorTipo(tipo, articuloId);
        if (articuloOpt.isEmpty()) return ResponseEntity.notFound().build();

        try {
            String urlImagen = cloudinaryService.subirImagen(file);

            ImagenArticulo nuevaImagen = ImagenArticulo.builder()
                    .urlImagen(urlImagen)
                    .denominacion(denominacion)
                    .articulo(articuloOpt.get())
                    .build();

            ImagenArticulo guardada = imagenArticuloService.save(nuevaImagen);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // LISTAR TODAS
    @GetMapping
    public ResponseEntity<List<ImagenArticulo>> listarTodas() {
        List<ImagenArticulo> imagenes = imagenArticuloService.findAll();
        return ResponseEntity.ok(imagenes);
    }

    // OBTENER POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ImagenArticulo> obtenerPorId(@PathVariable Long id) {
        Optional<ImagenArticulo> imagenOpt = imagenArticuloService.findById(id);
        return imagenOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<ImagenArticulo> actualizarImagen(
            @PathVariable Long id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("denominacion") String denominacion,
            @RequestParam("tipo") String tipo,
            @RequestParam("articuloId") Long articuloId) {

        Optional<ImagenArticulo> imagenOpt = imagenArticuloService.findById(id);
        if (imagenOpt.isEmpty()) return ResponseEntity.notFound().build();

        Optional<? extends Articulo> articuloOpt = buscarArticuloPorTipo(tipo, articuloId);
        if (articuloOpt.isEmpty()) return ResponseEntity.badRequest().build();

        ImagenArticulo imagen = imagenOpt.get();

        try {
            String urlImagen = imagen.getUrlImagen();

            if (file != null && !file.isEmpty()) {
                urlImagen = cloudinaryService.subirImagen(file);
            }

            ImagenArticulo actualizada = ImagenArticulo.builder()
                    .id(imagen.getId())
                    .urlImagen(urlImagen)
                    .denominacion(denominacion)
                    .articulo(articuloOpt.get())
                    .build();

            ImagenArticulo guardada = imagenArticuloService.save(actualizada);
            return ResponseEntity.ok(guardada);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarImagen(@PathVariable Long id) {
        Optional<ImagenArticulo> imagenOpt = imagenArticuloService.findById(id);
        if (imagenOpt.isEmpty()) return ResponseEntity.notFound().build();

        imagenArticuloService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // MÉTODO AUXILIAR PARA RESOLVER EL ARTÍCULO SEGÚN EL TIPO
    private Optional<? extends Articulo> buscarArticuloPorTipo(String tipo, Long id) {
        return switch (tipo.toLowerCase()) {
            case "insumo" -> articuloInsumoService.findById(id);
            case "manufacturado" -> articuloManufacturadoService.findById(id);
            default -> Optional.empty();
        };
    }
}
