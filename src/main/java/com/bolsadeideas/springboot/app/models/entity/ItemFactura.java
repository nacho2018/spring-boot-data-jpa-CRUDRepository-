package com.bolsadeideas.springboot.app.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="factura_items")
public class ItemFactura implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    @ManyToOne(fetch = FetchType.LAZY)
    private Factura factura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ItemFactura{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                '}';
    }

    public Long calcularImporte(){
        return cantidad .longValue();
    }
}
