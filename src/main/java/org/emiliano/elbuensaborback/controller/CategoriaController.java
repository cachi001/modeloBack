package org.emiliano.elbuensaborback.controller;

import org.emiliano.elbuensaborback.dto.CategoriaRequest;
import org.emiliano.elbuensaborback.dto.CategoriaResponse;
import org.emiliano.elbuensaborback.entity.Categoria;
import org.emiliano.elbuensaborback.mapper.CategoriaMapper;
import org.emiliano.elbuensaborback.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    public CategoriaController(CategoriaService categoriaService, CategoriaMapper categoriaMapper){
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearCategoria(@RequestBody CategoriaRequest categoriaRequest) {
        try {
            System.out.println("CREANDO CATEGORIA...");

            Categoria nuevaCategoria;

            System.out.println("ID" + categoriaRequest.getCategoriaPadreId()+ "denominacion" +  categoriaRequest.getDenominacion());
            if (categoriaRequest.getCategoriaPadreId() != null) {
                Optional<Categoria> categoriaPadreOp = categoriaService.findById(categoriaRequest.getCategoriaPadreId());
                if (categoriaPadreOp.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Categoría padre no encontrada");
                }

                nuevaCategoria = Categoria.builder()
                        .denominacion(categoriaRequest.getDenominacion())
                        .categoriaPadre(categoriaPadreOp.get())
                        .build();
            } else {
                nuevaCategoria = Categoria.builder()
                        .denominacion(categoriaRequest.getDenominacion())
                        .categoriaPadre(null)
                        .build();
            }

            Categoria categoriaGuardada = categoriaService.save(nuevaCategoria);

            CategoriaResponse categoriaDtoRespuesta = categoriaMapper.toResponseDto(categoriaGuardada);

            System.out.println("ID: " + categoriaDtoRespuesta.id());
            System.out.println("Denominación: " + categoriaDtoRespuesta.denominacion());

            if (categoriaDtoRespuesta.categoriaPadre() != null) {
                System.out.println("Padre ID: " + categoriaDtoRespuesta.categoriaPadre().getId());
                System.out.println("Padre Denominación: " + categoriaDtoRespuesta.categoriaPadre().getDenominacion());
            } else {
                System.out.println("Sin categoría padre.");
            }
            System.out.println("Estado: " + categoriaDtoRespuesta.activo());

            return ResponseEntity.ok(categoriaDtoRespuesta);
        } catch (Exception e) {
            System.out.println("ERROR CREANDO CATEGORIA CONTROLLER");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }


    @GetMapping("/all")
    public ResponseEntity<?> obtenerCategorias() {
        try {
            System.out.println("OBTENIENDO CATEGORIAS...");

            List<Categoria> listaCategorias = categoriaService.findAll();

            List<CategoriaResponse> listaDto = new ArrayList<>();
            for (Categoria categoria : listaCategorias) {
                CategoriaResponse dto = categoriaMapper.toResponseDto(categoria);
                listaDto.add(dto);
            }

            return ResponseEntity.ok(listaDto);
        } catch (Exception e) {
            System.out.println("ERROR OBTENIENDO CATEGORIAS CONTROLLER");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaRequest categoriaRequest) {
        try {
            Optional<Categoria> categoriaExistente = categoriaService.findById(id);
            if (categoriaExistente.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoría no encontrada");
            }

            Categoria categoria = categoriaExistente.get();
            categoria.setDenominacion(categoriaRequest.getDenominacion());

            if (categoriaRequest.getCategoriaPadreId() != null) {
                Optional<Categoria> categoriaPadre = categoriaService.findById(categoriaRequest.getCategoriaPadreId());
                if (categoriaPadre.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Categoría padre no encontrada");
                }
                categoria.setCategoriaPadre(categoriaPadre.get());
            } else {
                categoria.setCategoriaPadre(null);
            }

            Categoria actualizada = categoriaService.save(categoria);
            CategoriaResponse dto = categoriaMapper.toResponseDto(actualizada);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            System.out.println("ERROR ACTUALIZANDO CATEGORIA");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error actualizando categoría");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Long id) {
        try {
            if (categoriaService.findById(id).isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoría no encontrada");
            }
            categoriaService.deleteById(id);
            return ResponseEntity.ok("Categoría eliminada correctamente");
        } catch (Exception e) {
            System.out.println("ERROR ELIMINANDO CATEGORIA");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar categoría");
        }
    }

    @GetMapping("/hijas/{padreId}")
    public ResponseEntity<?> obtenerSubcategorias(@PathVariable Long padreId) {
        try {
            List<Categoria> subcategorias = categoriaService.findByCategoriaPadreId(padreId);
            List<CategoriaResponse> listaDto = new ArrayList<>();
            for (Categoria cat : subcategorias) {
                listaDto.add(categoriaMapper.toResponseDto(cat));
            }
            return ResponseEntity.ok(listaDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

    @PutMapping("/switch-state/{id}")
    public ResponseEntity<?> cambiarEstado(@PathVariable Long id) {
        try {
            System.out.println("CAMBIANDO ESTADO CATEGORIA...");

            return ResponseEntity.ok(categoriaMapper.toResponseDto(categoriaService.cambiarEstadoCategoria(id)));
        } catch (Exception e) {
            System.out.println("ERROR CAMBIANDO ESTADO CATEGORIA CONTROLLER");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

}
