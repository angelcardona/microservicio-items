package com.microservicios.items.infraestructura.adpatadores.entrada.mapper;

import com.microservicios.items.dominio.modelos.Item;
import com.microservicios.items.infraestructura.adpatadores.entrada.dto.ItemRequestDto;
import com.microservicios.items.infraestructura.adpatadores.entrada.dto.ItemResponseDto;

import java.util.List;

public interface ItemWebMapper {
    Item toDomain(ItemRequestDto itemRequestDto);
    ItemResponseDto toResponseDto(Item item);
    List<ItemResponseDto> toListResponseDto(List<Item> items);
}
