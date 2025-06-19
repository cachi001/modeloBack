package org.emiliano.elbuensaborback.mapper;

import org.emiliano.elbuensaborback.dto.ArticuloInsumoBaseResponse;
import org.emiliano.elbuensaborback.dto.ArticuloInsumoFullResponse;
import org.emiliano.elbuensaborback.dto.ArticuloInsumoRequest;
import org.emiliano.elbuensaborback.entity.ArticuloInsumo;
import org.emiliano.elbuensaborback.entity.Categoria;
import org.emiliano.elbuensaborback.entity.ImagenArticulo;
import org.emiliano.elbuensaborback.entity.UnidadMedida;
import org.emiliano.elbuensaborback.repository.ArticuloInsumoRepository;
import org.emiliano.elbuensaborback.repository.CategoriaRepository;
import org.emiliano.elbuensaborback.repository.UnidadMedidaRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ImagenArticuloMapper.class})
public abstract class ArticuloInsumoMapper {

    // Repositorios para cargar relaciones

    @Autowired
    protected ArticuloInsumoRepository articuloInsumoRepository;
    @Autowired
    protected CategoriaRepository categoriaRepository;

    @Autowired
    protected UnidadMedidaRepository unidadMedidaRepository;

    @Autowired
    protected ImagenArticuloMapper imagenArticuloMapper;

    // Mapea el DTO a la entidad base (sin relaciones)
    public abstract ArticuloInsumo toEntity(ArticuloInsumoRequest dto);

    public abstract ArticuloInsumo toEntityBase(ArticuloInsumoBaseResponse dto);

    // Mapea lista de entidades a respuestas simplificadas
    public abstract List<ArticuloInsumoBaseResponse> toBaseResponseList(List<ArticuloInsumo> insumos);

    // Respuesta individual simple
    public ArticuloInsumoBaseResponse toBaseResponse(ArticuloInsumo insumo) {
        if (insumo == null) return null;
        return new ArticuloInsumoBaseResponse(
                insumo.getId(),
                insumo.getDenominacion(),
                insumo.getUnidadMedida()
        );
    }
    // Después del mapeo base, resolvemos y asignamos las relaciones
    @AfterMapping
    protected void mapRelations(@MappingTarget ArticuloInsumo insumo, ArticuloInsumoRequest dto) {
        insumo.setStockActual(dto.getStockActual());
        insumo.setDenominacion(dto.getDenominacion());
        insumo.setEsParaElaborar(dto.getEsParaElaborar());
        insumo.setPrecioVenta(dto.getPrecioVenta());
        insumo.setPrecioCompra(dto.getPrecioCompra());
        insumo.setStockMaximo(dto.getStockMaximo());
        insumo.setActivo(true);

        Categoria categoria = categoriaRepository.findByDenominacion(dto.getCategoria().getDenominacion())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + dto.getCategoria().getDenominacion()));
        insumo.setCategoria(categoria);

        UnidadMedida unidadMedida = unidadMedidaRepository.findByDenominacion(dto.getUnidadMedida().getDenominacion())
                .orElseGet(() -> {
                    UnidadMedida nuevaUnidad = new UnidadMedida();
                    nuevaUnidad.setDenominacion(dto.getUnidadMedida().getDenominacion().toLowerCase());
                    return unidadMedidaRepository.save(nuevaUnidad);
                });
        insumo.setUnidadMedida(unidadMedida);

        if (dto.getImagenes() != null && !dto.getImagenes().isEmpty()) {
            List<ImagenArticulo> imagenes = dto.getImagenes().stream()
                    .map(imagenDto -> {
                        ImagenArticulo imagen = imagenArticuloMapper.toEntity(imagenDto);
                        imagen.setArticulo(insumo); // relación acá
                        return imagen;
                    }).toList();
            insumo.setImagenes(imagenes);
        }
    }

    @AfterMapping
    protected void mapearRelaciones(@MappingTarget ArticuloInsumo entity, ArticuloInsumoBaseResponse dto ) {
        ArticuloInsumo insumo = articuloInsumoRepository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Insumo no encontrado: " + dto.denominacion()));
        entity.setId(insumo.getId());
        entity.setDenominacion(insumo.getDenominacion());
        entity.setStockActual(insumo.getStockActual());
        entity.setStockMaximo(insumo.getStockMaximo());
        entity.setEsParaElaborar(insumo.getEsParaElaborar());
        entity.setPrecioCompra(insumo.getPrecioCompra());
        entity.setImagenes(insumo.getImagenes());
        entity.setCategoria(insumo.getCategoria());
        entity.setUnidadMedida(insumo.getUnidadMedida());
        entity.setPrecioVenta(insumo.getPrecioVenta());
        entity.setActivo(insumo.getActivo());
    }

}
