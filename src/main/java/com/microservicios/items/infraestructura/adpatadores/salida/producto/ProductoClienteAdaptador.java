package com.microservicios.items.infraestructura.adpatadores.salida.producto;

import com.microservicios.items.aplicacion.puertos.salida.ProductoCatalogoPuertoSalida;
import com.microservicios.items.dominio.modelos.Producto;
import feign.FeignException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductoClienteAdaptador implements ProductoCatalogoPuertoSalida {

    private final ProductoFeignCliente productoFeignCliente;
    private final ProductoCatalogoMapper mapper;

    public ProductoClienteAdaptador(ProductoFeignCliente productoFeignCliente, ProductoCatalogoMapper mapper) {
        this.productoFeignCliente = productoFeignCliente;
        this.mapper = mapper;
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        try{
            return  Optional.ofNullable(productoFeignCliente.obtenerProductoPorId(id))
                    .map(mapper::toDomain);
        }catch (FeignException.NotFound e){
            System.out.println("Producto con id " + id + " no encontrado en el servicio productos error : " + e);
            return Optional.empty();
        }
    }
}
