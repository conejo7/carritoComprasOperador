package com.unir.carritocomprasoperador.model.pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pedido_detalle", schema = "carrito_operador", catalog = "")
public class PedidoDetalle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ped_det_id")
    private int pedDetId;
    @Basic
    @Column(name = "ped_id")
    private int pedId;
    @Basic
    @Column(name = "ped_det_catidad")
    private Integer pedDetCatidad;
    @Basic
    @Column(name = "ped_det_descripcion")
    private String pedDetDescripcion;

    public int getPedDetId() {
        return pedDetId;
    }

    public void setPedDetId(int pedDetId) {
        this.pedDetId = pedDetId;
    }

    public int getPedId() {
        return pedId;
    }

    public void setPedId(int pedId) {
        this.pedId = pedId;
    }

    public Integer getPedDetCatidad() {
        return pedDetCatidad;
    }

    public void setPedDetCatidad(Integer pedDetCatidad) {
        this.pedDetCatidad = pedDetCatidad;
    }

    public String getPedDetDescripcion() {
        return pedDetDescripcion;
    }

    public void setPedDetDescripcion(String pedDetDescripcion) {
        this.pedDetDescripcion = pedDetDescripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoDetalle that = (PedidoDetalle) o;
        return pedDetId == that.pedDetId && pedId == that.pedId && Objects.equals(pedDetCatidad, that.pedDetCatidad) && Objects.equals(pedDetDescripcion, that.pedDetDescripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedDetId, pedId, pedDetCatidad, pedDetDescripcion);
    }
}
