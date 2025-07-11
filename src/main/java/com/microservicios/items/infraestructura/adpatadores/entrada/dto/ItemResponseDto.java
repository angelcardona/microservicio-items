package com.microservicios.items.infraestructura.adpatadores.entrada.dto;

import com.microservicios.items.dominio.modelos.Producto;

public class ItemResponseDto {

    private Long id;
    private Long productoId;
    private Integer cantidad;
    private Producto productoDetalle;
    private Double precioTotal;

    public ItemResponseDto(Long id, Long productoId, Integer cantidad, Producto productoDetalle, Double precioTotal) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.productoDetalle = productoDetalle;
        this.precioTotal = precioTotal;
    }

    public ItemResponseDto() {
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

    public Producto getProductoDetalle() {
        return productoDetalle;
    }

    public void setProductoDetalle(Producto productoDetalle) {
        this.productoDetalle = productoDetalle;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
