package com.microservicios.items.infraestructura.adpatadores.salida.persistencia;

import com.microservicios.items.dominio.modelos.Producto;
import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productoId;
    private Integer cantidad;
    @Transient
    private Producto productoDetalle;

    public ItemEntity(Long id, Long productoId, Integer cantidad) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public ItemEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
