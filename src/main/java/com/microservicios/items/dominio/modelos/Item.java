package com.microservicios.items.dominio.modelos;

public class Item {

    private Long id;
    private Long productoId;
    private Integer cantidad;
    private Producto productoDetalle;


    public Double calcularPrecioTotal(){
        if(cantidad == null || productoDetalle.getPrecio()== null){
            return null;
        }else{
            return cantidad * productoDetalle.getPrecio();
        }
    }

    public Item() {
    }

    public Item(Long id, Long productoId, Integer cantidad, Producto productoDetalle) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.productoDetalle = productoDetalle;
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
}
