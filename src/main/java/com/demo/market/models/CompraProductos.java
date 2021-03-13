package com.demo.market.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="compras_productos")
public class CompraProductos {
    @EmbeddedId
    private CompraProductosPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;

    public CompraProductosPK getId() {
        return id;
    }

    public void setId(CompraProductosPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
