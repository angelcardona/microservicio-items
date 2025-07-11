package com.microservicios.items.infraestructura.adpatadores.salida.persistencia;

import com.microservicios.items.aplicacion.puertos.salida.ItemPuertoSalida;
import com.microservicios.items.dominio.modelos.Item;

import java.util.List;
import java.util.Optional;

public class ItemPersistenciaAdaptador implements ItemPuertoSalida {

    private final ItemJpaRepository repository;
    private final ItemMapper mapper;

    public ItemPersistenciaAdaptador(ItemJpaRepository repository, ItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Item save(Item item) {
        return mapper.toDomain(repository.save(mapper.toEntity(item)));
    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Item> findAll() {
        return mapper.toItemList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }
}
