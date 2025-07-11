package com.microservicios.items.infraestructura.adpatadores.salida.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemJpaRepository extends JpaRepository<ItemEntity,Long> {
}
