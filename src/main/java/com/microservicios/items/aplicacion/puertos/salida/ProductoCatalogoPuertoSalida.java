package com.microservicios.items.aplicacion.puertos.salida;

import com.microservicios.items.dominio.modelos.Producto;

import java.util.Optional;

public interface ProductoCatalogoPuertoSalida {
    Optional<Producto> obtenerProductoPorId(Long id);
}
