package com.microservicios.items.aplicacion.puertos.entrada;

import com.microservicios.items.dominio.modelos.Item;

import java.util.List;
import java.util.Optional;

public interface ItemPuertoEntrada {
    Item crearItem(Item item);
    Optional<Item> obtenerItemPorId(Long id);
    List<Item> obtenerTodosLosItems();
    void eliminarItem(Long id);
}
