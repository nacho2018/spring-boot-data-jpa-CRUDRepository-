package com.bolsadeideas.springboot.app.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String observacion;

    @Temporal(TemporalType.DATE)
    @Column(name="create_at")
    private Date createAt;

   @ManyToOne(fetch=FetchType.LAZY)
   @JsonIgnore
    private Cliente cliente;

   @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name="factura_id")
   List<ItemFactura> items;

   @PrePersist
   public void prePersist(){
       //generates date just before persisting
       createAt = new Date();
   }
    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", observacion='" + observacion + '\'' +
                ", createAt=" + createAt +
                ", cliente=" + cliente.toString() +
                '}';
    }

    public Factura() {
      this.items = new ArrayList<>();
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItemFactura(ItemFactura item){
       this.items.add(item);
    }
}
