package org.emiliano.elbuensaborback.mapper;

import org.emiliano.elbuensaborback.dto.ArticuloManufacturadoRequest;
import org.emiliano.elbuensaborback.entity.*;
import org.emiliano.elbuensaborback.repository.CategoriaRepository;
import org.emiliano.elbuensaborback.repository.UnidadMedidaRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true), uses = {ImagenArticuloMapper.class, ArticuloInsumoMapper.class, ArticuloManufacturadoDetalleMapper.class})
public abstract class ArticuloManufacturadoMapper {

    @Autowired
    protected CategoriaRepository categoriaRepository;

    @Autowired
    protected UnidadMedidaRepository unidadMedidaRepository;

    @Autowired
    protected ArticuloManufacturadoDetalleMapper detalleMapper;

    @Autowired
    protected ImagenArticuloMapper imagenArticuloMapper;

    public abstract ArticuloManufacturado toEntity(ArticuloManufacturadoRequest dto);

    @AfterMapping
    protected void mapRelations(@MappingTarget ArticuloManufacturado manufacturado, ArticuloManufacturadoRequest dto) {
        manufacturado.setActivo(true);

        // ⬅️ Setear campos heredados
        manufacturado.setDenominacion(dto.getDenominacion());
        manufacturado.setPrecioVenta(dto.getPrecioVenta());

        // ⬅️ Campos propios
        manufacturado.setDescripcion(dto.getDescripcion());
        manufacturado.setPreparacion(dto.getPreparacion());
        manufacturado.setTiempoEstimado(dto.getTiempoEstimado());

        // Categoría
        Categoria categoria = categoriaRepository.findByDenominacion(dto.getCategoria().getDenominacion())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + dto.getCategoria().getDenominacion()));
        manufacturado.setCategoria(categoria);

        // Unidad de medida
        UnidadMedida unidadMedida = unidadMedidaRepository.findByDenominacion(dto.getUnidadMedida().getDenominacion())
                .orElseGet(() -> {
                    UnidadMedida nueva = new UnidadMedida();
                    nueva.setDenominacion(dto.getUnidadMedida().getDenominacion().toLowerCase());
                    return unidadMedidaRepository.save(nueva);
                });
        manufacturado.setUnidadMedida(unidadMedida);

        // Detalles
        if (dto.getArticuloManufacturadoDetalles() != null) {
            List<ArticuloManufacturadoDetalle> detalles = detalleMapper.toEntityList(dto.getArticuloManufacturadoDetalles());
            manufacturado.setArticuloManufacturadoDetalles(detalles);
        }
        if (dto.getImagenes() != null && !dto.getImagenes().isEmpty()) {
            List<ImagenArticulo> imagenes = dto.getImagenes().stream()
                    .map(imagenDto -> {
                        ImagenArticulo imagen = imagenArticuloMapper.toEntity(imagenDto);
                        imagen.setArticulo(manufacturado); // relación acá
                        return imagen;
                    }).toList();
            manufacturado.setImagenes(imagenes);
        }

        System.out.println("MANUFACTURADO MAPEADO: " + manufacturado);
    }

}
