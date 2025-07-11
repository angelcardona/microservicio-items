package com.microservicios.items.aplicacion.servicios;

import com.microservicios.items.aplicacion.puertos.entrada.ItemPuertoEntrada;
import com.microservicios.items.aplicacion.puertos.salida.ItemPuertoSalida;
import com.microservicios.items.aplicacion.puertos.salida.ProductoCatalogoPuertoSalida;
import com.microservicios.items.dominio.modelos.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServicio implements ItemPuertoEntrada {

    private final ItemPuertoSalida puertoSalida;
    private final ProductoCatalogoPuertoSalida catalogoPuertoSalida;

    public ItemServicio(ItemPuertoSalida puertoSalida, ProductoCatalogoPuertoSalida catalogoPuertoSalida) {
        this.puertoSalida = puertoSalida;
        this.catalogoPuertoSalida = catalogoPuertoSalida;
    }


    @Override
    public Item crearItem(Item item) {
        return puertoSalida.save(item);
    }

    @Override
    public Optional<Item> obtenerItemPorId(Long id) {
        return puertoSalida.findById(id)
                .map(item -> {
                    catalogoPuertoSalida.obtenerProductoPorId(item.getProductoId())
                            .ifPresent(item::setProductoDetalle);
                    return item;
                });
    }

    @Override
    public List<Item> obtenerTodosLosItems() {
        return puertoSalida.findAll().stream()
                .map(item -> {
                    catalogoPuertoSalida.obtenerProductoPorId(item.getProductoId())
                            .ifPresent(item::setProductoDetalle);
                    return item;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarItem(Long id) {
        puertoSalida.delete(id);
    }
    public  Item modificarItem(Item item){
        return puertoSalida.findById(item.getId()).map(itemExistente ->{
            itemExistente.setCantidad(item.getCantidad());
            itemExistente.setProductoDetalle(item.getProductoDetalle());
            return itemExistente;
        }).orElseThrow(() -> new RuntimeException("item no encontrado por id"));
    }
}
