package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.dto.ArticuloInsumoDto;
import org.emiliano.elbuensaborback.entity.ArticuloInsumo;
import org.emiliano.elbuensaborback.entity.Categoria;
import org.emiliano.elbuensaborback.entity.UnidadMedida;
import org.emiliano.elbuensaborback.repository.ArticuloInsumoRepository;
import org.emiliano.elbuensaborback.repository.CategoriaRepository;
import org.emiliano.elbuensaborback.repository.UnidadMedidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloInsumoService extends BaseServiceImpl<ArticuloInsumo, Long>{


    private final ArticuloInsumoRepository articuloInsumoRepository;
    private final CategoriaRepository categoriaRepository;
    private final UnidadMedidaRepository unidadMedidaRepository;

    public ArticuloInsumoService(
            ArticuloInsumoRepository articuloInsumoRepository,
            CategoriaRepository categoriaRepository,
            UnidadMedidaRepository unidadMedidaRepository ) {
        super(articuloInsumoRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
        this.categoriaRepository = categoriaRepository;
        this.unidadMedidaRepository = unidadMedidaRepository;
    }

    @Override
    public ArticuloInsumo save(ArticuloInsumo entity) {
        return super.save(entity);
    }

    @Override
    public ArticuloInsumo update(ArticuloInsumo entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<ArticuloInsumo> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<ArticuloInsumo> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    public ArticuloInsumo crear(ArticuloInsumoDto dto) {
        ArticuloInsumo insumo = new ArticuloInsumo();
        insumo.setDenominacion(dto.getDenominacion());
        insumo.setPrecioCompra(dto.getPrecioCompra());
        insumo.setStockActual(dto.getStockActual());
        insumo.setStockMaximo(dto.getStockMaximo());
        insumo.setEsParaElaborar(dto.getEsParaElaborar());
        insumo.setPrecioVenta(dto.getPrecioVenta());

        // Cargar relaciones desde DB
        Categoria categoria = categoriaRepository.findByDenominacion(dto.getCategoria().getDenominacion())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + dto.getCategoria().getDenominacion()));

        UnidadMedida unidadMedida = unidadMedidaRepository.findByDenominacion(dto.getUnidadMedida().getDenominacion())
                .orElseGet(() -> {
                    UnidadMedida nuevaUnidad = new UnidadMedida();
                    nuevaUnidad.setDenominacion(dto.getUnidadMedida().getDenominacion().toLowerCase());
                    return unidadMedidaRepository.save(nuevaUnidad);
                });

        insumo.setCategoria(categoria);
        insumo.setUnidadMedida(unidadMedida);

        ArticuloInsumo insumoGuardado = articuloInsumoRepository.save(insumo);

        return insumoGuardado;

    }
    public List<ArticuloInsumo> listarTodos() {
        return articuloInsumoRepository.findAll();
    }

    public ArticuloInsumo obtenerPorId(Long id) {
        return articuloInsumoRepository.findById(id).orElse(null);
    }

    public ArticuloInsumo actualizar(Long id, ArticuloInsumoDto dto) {
        Optional<ArticuloInsumo> optionalInsumo = articuloInsumoRepository.findById(id);
        if (optionalInsumo.isEmpty()) {
            return null;
        }
        ArticuloInsumo insumo = optionalInsumo.get();

        insumo.setDenominacion(dto.getDenominacion());
        insumo.setPrecioCompra(dto.getPrecioCompra());
        insumo.setStockActual(dto.getStockActual());
        insumo.setStockMaximo(dto.getStockMaximo());
        insumo.setEsParaElaborar(dto.getEsParaElaborar());
        insumo.setPrecioVenta(dto.getPrecioVenta());

        // Actualizar categoría
        Categoria categoria = categoriaRepository.findByDenominacion(dto.getCategoria().getDenominacion())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + dto.getCategoria().getDenominacion()));
        insumo.setCategoria(categoria);

        // Actualizar unidad de medida
        UnidadMedida unidadMedida = unidadMedidaRepository.findByDenominacion(dto.getUnidadMedida().getDenominacion())
                .orElseGet(() -> {
                    UnidadMedida nuevaUnidad = new UnidadMedida();
                    nuevaUnidad.setDenominacion(dto.getUnidadMedida().getDenominacion().toLowerCase());
                    return unidadMedidaRepository.save(nuevaUnidad);
                });
        insumo.setUnidadMedida(unidadMedida);

        return articuloInsumoRepository.save(insumo);
    }

    public boolean eliminar(Long id) {
        if (articuloInsumoRepository.existsById(id)) {
            articuloInsumoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
