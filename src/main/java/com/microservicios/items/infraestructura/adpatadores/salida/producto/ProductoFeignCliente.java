package com.microservicios.items.infraestructura.adpatadores.salida.producto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productos",url = "http://localhost:8081")
public interface ProductoFeignCliente {
    @GetMapping("api/productos/{id}")
    ProductoDTO obtenerProductoPorId(@PathVariable("id") Long id);
}
