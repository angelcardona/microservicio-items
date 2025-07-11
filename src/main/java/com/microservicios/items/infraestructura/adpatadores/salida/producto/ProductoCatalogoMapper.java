package com.microservicios.items.infraestructura.adpatadores.salida.producto;

import com.microservicios.items.dominio.modelos.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoCatalogoMapper {
    Producto toDomain(ProductoDTO productoDTO);
}
