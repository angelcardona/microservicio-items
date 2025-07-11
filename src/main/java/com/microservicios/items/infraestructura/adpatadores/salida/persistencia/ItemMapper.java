package com.microservicios.items.infraestructura.adpatadores.salida.persistencia;

import com.microservicios.items.dominio.modelos.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemEntity toEntity(Item item);
    Item toDomain(ItemEntity itemEntity);
    List<Item> toItemList(List<ItemEntity> itemEntities);
}
