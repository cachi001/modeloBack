package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.dto.ArticuloManufacturadoRequest;
import org.emiliano.elbuensaborback.entity.ArticuloManufacturado;
import org.emiliano.elbuensaborback.mapper.ArticuloInsumoMapper;
import org.emiliano.elbuensaborback.mapper.ArticuloManufacturadoMapper;
import org.emiliano.elbuensaborback.repository.ArticuloInsumoRepository;
import org.emiliano.elbuensaborback.repository.ArticuloManufacturadoRepository;
import org.emiliano.elbuensaborback.repository.CategoriaRepository;
import org.emiliano.elbuensaborback.repository.UnidadMedidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloManufacturadoService extends BaseServiceImpl<ArticuloManufacturado, Long> {

    private final ArticuloManufacturadoRepository articuloManufacturadoRepository;
    private final ArticuloInsumoRepository articuloInsumoRepository;
    private final CategoriaRepository categoriaRepository;
    private final UnidadMedidaRepository unidadMedidaRepository;
    private final ArticuloInsumoMapper articuloInsumoMapper;
    private final ArticuloManufacturadoMapper articuloManufacturadoMapper;

    public ArticuloManufacturadoService(
            ArticuloManufacturadoRepository articuloManufacturadoRepository,
            ArticuloInsumoRepository articuloInsumoRepository,
            CategoriaRepository categoriaRepository,
            UnidadMedidaRepository unidadMedidaRepository,
            ArticuloInsumoMapper articuloInsumoMapper,
            ArticuloManufacturadoMapper articuloManufacturadoMapper
    ) {
        super(articuloManufacturadoRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
        this.articuloInsumoRepository = articuloInsumoRepository;
        this.categoriaRepository = categoriaRepository;
        this.unidadMedidaRepository = unidadMedidaRepository;
        this.articuloInsumoMapper = articuloInsumoMapper;
        this.articuloManufacturadoMapper = articuloManufacturadoMapper;
    }

    public ArticuloManufacturado crearDesdeRequest(ArticuloManufacturadoRequest request) {
        ArticuloManufacturado manufacturado = articuloManufacturadoMapper.toEntity(request);
        System.out.println("DATOS SERVICE: ");
        System.out.println(manufacturado.toString());
        return articuloManufacturadoRepository.save(manufacturado);
    }
    @Override
    public ArticuloManufacturado save(ArticuloManufacturado entity) {
        return articuloManufacturadoRepository.save(entity);
    }

    @Override
    public ArticuloManufacturado update(ArticuloManufacturado entity, Long id) {
        Optional<ArticuloManufacturado> optional = articuloManufacturadoRepository.findById(id);
        if (optional.isPresent()) {
            ArticuloManufacturado existente = optional.get();
            // Actualiza los campos necesarios
            existente.setDenominacion(entity.getDenominacion());
            existente.setDescripcion(entity.getDescripcion());
            existente.setPrecioVenta(entity.getPrecioVenta());
            existente.setTiempoEstimado(entity.getTiempoEstimado());
            existente.setCategoria(entity.getCategoria());
            existente.setUnidadMedida(entity.getUnidadMedida());
            existente.setArticuloManufacturadoDetalles(entity.getArticuloManufacturadoDetalles());
            return articuloManufacturadoRepository.save(existente);
        } else {
            throw new RuntimeException("Manufacturado con ID " + id + " no encontrado para actualizar");
        }
    }

    @Override
    public Optional<ArticuloManufacturado> findById(Long id) {
        return articuloManufacturadoRepository.findById(id);
    }

    @Override
    public List<ArticuloManufacturado> findAll() {
        return articuloManufacturadoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!articuloManufacturadoRepository.existsById(id)) {
            throw new RuntimeException("Manufacturado con ID " + id + " no encontrado para eliminar");
        }
        articuloManufacturadoRepository.deleteById(id);
    }

    public ArticuloManufacturado cambiarEstadoManufacturado(Long id) {
        Optional<ArticuloManufacturado> manufacturadoOptional = articuloManufacturadoRepository.findById(id);

        if (manufacturadoOptional.isEmpty()) {
            throw new RuntimeException("Manufacturado con ID " + id + " no encontrado");
        }

        ArticuloManufacturado manufacturado = manufacturadoOptional.get();
        manufacturado.setActivo(!manufacturado.getActivo()); // Cambia el estado
        return articuloManufacturadoRepository.save(manufacturado);
    }
}
