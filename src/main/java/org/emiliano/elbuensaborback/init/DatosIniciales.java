package org.emiliano.elbuensaborback.init;

import lombok.RequiredArgsConstructor;
import org.emiliano.elbuensaborback.entity.*;
import org.emiliano.elbuensaborback.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatosIniciales implements CommandLineRunner {

    private final ArticuloManufacturadoRepository manufacturadoRepo;
    private final ArticuloInsumoRepository insumoRepo;
    private final ArticuloManufacturadoDetalleRepository detalleRepo;
    private final UnidadMedidaRepository unidadRepo;
    private final CategoriaRepository categoriaRepo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🚀 Cargando datos iniciales...");

        if (categoriaRepo.count() > 0) {
            System.out.println("⚠️ Datos iniciales ya fueron cargados, se omite la carga.");
            return;  // Salir para no cargar otra vez
        }

        var categoriaManufacturado = categoriaRepo.save(
                Categoria.builder()
                        .denominacion("Manufacturado")
                        .categoriaPadre(null)
                        .build()
        );

        var categoriaInsumo = categoriaRepo.save(
                Categoria.builder()
                        .denominacion("Insumo")
                        .categoriaPadre(null)
                        .build()
        );

//        // UNIDADES DE MEDIDA
//        var gramos = unidadRepo.save(UnidadMedida.builder().denominacion("Gramos").build());
//        var litros = unidadRepo.save(UnidadMedida.builder().denominacion("Litros").build());
//        var unidades = unidadRepo.save(UnidadMedida.builder().denominacion("Unidades").build());
//
//        // CATEGORÍAS Y SUBCATEGORÍAS
//        var catComidas = categoriaRepo.save(Categoria.builder().denominacion("Comidas").build());
//        var catBebidas = categoriaRepo.save(Categoria.builder().denominacion("Bebidas").build());
//
//        var catHamburguesas = categoriaRepo.save(Categoria.builder()
//                .denominacion("Hamburguesas")
//                .categoriaPadre(catComidas)
//                .build());
//
//        var catPizzas = categoriaRepo.save(Categoria.builder()
//                .denominacion("Pizzas")
//                .categoriaPadre(catComidas)
//                .build());
//
//        var catCervezas = categoriaRepo.save(Categoria.builder()
//                .denominacion("Cervezas")
//                .categoriaPadre(catBebidas)
//                .build());
//
//        var catGaseosas = categoriaRepo.save(Categoria.builder()
//                .denominacion("Gaseosas")
//                .categoriaPadre(catBebidas)
//                .build());
//
//        // INSUMOS
//        var pan = insumoRepo.save(ArticuloInsumo.builder()
//                .denominacion("Pan de hamburguesa")
//                .precioVenta(40.0)
//                .precioCompra(new BigDecimal("30"))
//                .stockActual(200)
//                .stockMaximo(400)
//                .esParaElaborar(true)
//                .unidadMedida(unidades)
//                .categoria(catHamburguesas)
//                .build());
//
//        var carne = insumoRepo.save(ArticuloInsumo.builder()
//                .denominacion("Carne vacuna")
//                .precioVenta(200.0)
//                .precioCompra(new BigDecimal("150"))
//                .stockActual(100)
//                .stockMaximo(200)
//                .esParaElaborar(true)
//                .unidadMedida(gramos)
//                .categoria(catHamburguesas)
//                .build());
//
//        var queso = insumoRepo.save(ArticuloInsumo.builder()
//                .denominacion("Queso cheddar")
//                .precioVenta(50.0)
//                .precioCompra(new BigDecimal("40"))
//                .stockActual(80)
//                .stockMaximo(160)
//                .esParaElaborar(true)
//                .unidadMedida(gramos)
//                .categoria(catHamburguesas)
//                .build());
//
//        var masaPizza = insumoRepo.save(ArticuloInsumo.builder()
//                .denominacion("Masa de pizza")
//                .precioVenta(70.0)
//                .precioCompra(new BigDecimal("55"))
//                .stockActual(60)
//                .stockMaximo(100)
//                .esParaElaborar(true)
//                .unidadMedida(unidades)
//                .categoria(catPizzas)
//                .build());
//
//        var salsaTomate = insumoRepo.save(ArticuloInsumo.builder()
//                .denominacion("Salsa de tomate")
//                .precioVenta(30.0)
//                .precioCompra(new BigDecimal("20"))
//                .stockActual(90)
//                .stockMaximo(150)
//                .esParaElaborar(true)
//                .unidadMedida(litros)
//                .categoria(catPizzas)
//                .build());
//
//        var gaseosaCola = insumoRepo.save(ArticuloInsumo.builder()
//                .denominacion("Gaseosa de cola")
//                .precioVenta(150.0)
//                .precioCompra(new BigDecimal("100"))
//                .stockActual(50)
//                .stockMaximo(100)
//                .esParaElaborar(false)
//                .unidadMedida(litros)
//                .categoria(catGaseosas)
//                .build());
//
//        var cervezaRubia = insumoRepo.save(ArticuloInsumo.builder()
//                .denominacion("Cerveza rubia")
//                .precioVenta(200.0)
//                .precioCompra(new BigDecimal("150"))
//                .stockActual(80)
//                .stockMaximo(120)
//                .esParaElaborar(false)
//                .unidadMedida(litros)
//                .categoria(catCervezas)
//                .build());
//
//        // ARTÍCULO MANUFACTURADO: HAMBURGUESA DOBLE
//        var detallesHamburguesa = List.of(
//                detalleRepo.save(new ArticuloManufacturadoDetalle(null, 1, pan)),
//                detalleRepo.save(new ArticuloManufacturadoDetalle(null, 2, carne)),
//                detalleRepo.save(new ArticuloManufacturadoDetalle(null, 1, queso))
//        );
//
//        var hamburguesaDoble = manufacturadoRepo.save(ArticuloManufacturado.builder()
//                .denominacion("Hamburguesa Doble")
//                .descripcion("Pan, doble carne y queso cheddar")
//                .precioVenta(1200.0)
//                .tiempoEstimado(20)
//                .preparacion("Cocinar carne, armar con queso y pan.")
//                .unidadMedida(unidades)
//                .categoria(catHamburguesas)
//                .articuloManufacturadoDetalles(detallesHamburguesa)
//                .build());
//
//        // ARTÍCULO MANUFACTURADO: PIZZA MUZZARELLA
//        var detallesPizza = List.of(
//                detalleRepo.save(new ArticuloManufacturadoDetalle(null, 1, masaPizza)),
//                detalleRepo.save(new ArticuloManufacturadoDetalle(null, 1, salsaTomate)),
//                detalleRepo.save(new ArticuloManufacturadoDetalle(null, 1, queso))
//        );
//
//        var pizzaMuzza = manufacturadoRepo.save(ArticuloManufacturado.builder()
//                .denominacion("Pizza Muzzarella")
//                .descripcion("Pizza con salsa y queso")
//                .precioVenta(1400.0)
//                .tiempoEstimado(25)
//                .preparacion("Preparar masa, agregar salsa y queso, hornear.")
//                .unidadMedida(unidades)
//                .categoria(catPizzas)
//                .articuloManufacturadoDetalles(detallesPizza)
//                .build());
//
//        System.out.println("✅ Datos iniciales cargados correctamente.");
    }
}
