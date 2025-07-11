package com.microservicios.items.aplicacion.puertos.salida;

import com.microservicios.items.dominio.modelos.Item;

import java.util.List;
import java.util.Optional;

public interface ItemPuertoSalida {
    Item save(Item item);
    Optional<Item> findById(Long id);
    List<Item> findAll();
    void delete(Long id);
}
