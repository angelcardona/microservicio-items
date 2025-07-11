package com.microservicios.items.infraestructura.adpatadores.entrada.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ItemRequestDto {

    private Long id;

    @NotNull(message = "El ID del producto no puede ser nulo")
    @Positive(message = "El ID del producto debe ser positivo")
    private Long productoId;
    @NotNull(message = "La cantidad no puede ser nulo")
    @Positive(message = "La cantidad debe ser positiva debe ser positivo")
    private Integer cantidad;

    public ItemRequestDto() {
    }

    public ItemRequestDto(Long id, Long productoId, Integer cantidad) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
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
