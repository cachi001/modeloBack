package org.emiliano.elbuensaborback.controller;

import org.emiliano.elbuensaborback.dto.CategoriaDto;
import org.emiliano.elbuensaborback.dto.CategoriaDtoDenominacion;
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
    public ResponseEntity<?> crearCategoria(@RequestBody CategoriaDto categoriaDto) {
        try {
            System.out.println("CREANDO CATEGORIA...");

            Categoria nuevaCategoria;

            if (categoriaDto.getCategoriaPadreId() != null) {
                Optional<Categoria> categoriaPadreOp = categoriaService.findById(categoriaDto.getCategoriaPadreId());
                if (categoriaPadreOp.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Categoría padre no encontrada");
                }

                nuevaCategoria = Categoria.builder()
                        .denominacion(categoriaDto.getDenominacion())
                        .categoriaPadre(categoriaPadreOp.get())
                        .build();
            } else {
                nuevaCategoria = Categoria.builder()
                        .denominacion(categoriaDto.getDenominacion())
                        .categoriaPadre(null)
                        .build();
            }

            Categoria categoriaGuardada = categoriaService.save(nuevaCategoria);
            CategoriaDtoDenominacion categoriaDtoNueva = categoriaMapper.toDto(categoriaGuardada);

            System.out.println(categoriaDtoNueva.getCategoriaPadreDenominacion() + " " + categoriaDtoNueva.getDenominacion() + " " + categoriaDtoNueva.getId());
            return ResponseEntity.ok(categoriaDtoNueva);
        } catch (Exception e) {
            System.out.println("ERROR CREANDO CATEGORIA CONTROLLER");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }


    @GetMapping("/todas")
    public ResponseEntity<?> obtenerCategorias() {
        try {
            System.out.println("OBTENIENDO CATEGORIAS...");

            List<Categoria> listaCategorias = categoriaService.findAll();

            List<CategoriaDtoDenominacion> listaDto = new ArrayList<>();
            for (Categoria categoria : listaCategorias) {
                CategoriaDtoDenominacion dto = categoriaMapper.toDto(categoria);
                listaDto.add(dto);
            }

            return ResponseEntity.ok(listaDto);
        } catch (Exception e) {
            System.out.println("ERROR OBTENIENDO CATEGORIAS CONTROLLER");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
