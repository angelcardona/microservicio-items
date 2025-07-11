package com.microservicios.items.infraestructura.adpatadores.salida.persistencia;

import com.microservicios.items.dominio.modelos.Item;

import java.util.List;

public interface ItemMapper {
    ItemEntity toEntity(Item item);
    Item toDomain(ItemEntity itemEntity);
    List<Item> toItemList(List<ItemEntity> itemEntities);
}
