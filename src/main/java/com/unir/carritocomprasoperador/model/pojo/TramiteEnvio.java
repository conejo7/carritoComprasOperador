package com.unir.carritocomprasoperador.model.pojo;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tramite_envio", schema = "carrito_operador", catalog = "")
public class TramiteEnvio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tra_env_id")
    private int traEnvId;
    @Basic
    @Column(name = "ped_id")
    private int pedId;
    @Basic
    @Column(name = "tra_fecha_envio")
    private Timestamp traFechaEnvio;
    @Basic
    @Column(name = "tra_fecha_entrega")
    private Timestamp traFechaEntrega;
    @Basic
    @Column(name = "tra_direccion_entrega")
    private String traDireccionEntrega;
    @Basic
    @Column(name = "tra_estado")
    private Byte traEstado;

    public int getTraEnvId() {
        return traEnvId;
    }

    public void setTraEnvId(int traEnvId) {
        this.traEnvId = traEnvId;
    }

    public int getPedId() {
        return pedId;
    }

    public void setPedId(int pedId) {
        this.pedId = pedId;
    }

    public Timestamp getTraFechaEnvio() {
        return traFechaEnvio;
    }

    public void setTraFechaEnvio(Timestamp traFechaEnvio) {
        this.traFechaEnvio = traFechaEnvio;
    }

    public Timestamp getTraFechaEntrega() {
        return traFechaEntrega;
    }

    public void setTraFechaEntrega(Timestamp traFechaEntrega) {
        this.traFechaEntrega = traFechaEntrega;
    }

    public String getTraDireccionEntrega() {
        return traDireccionEntrega;
    }

    public void setTraDireccionEntrega(String traDireccionEntrega) {
        this.traDireccionEntrega = traDireccionEntrega;
    }

    public Byte getTraEstado() {
        return traEstado;
    }

    public void setTraEstado(Byte traEstado) {
        this.traEstado = traEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TramiteEnvio that = (TramiteEnvio) o;
        return traEnvId == that.traEnvId && pedId == that.pedId && Objects.equals(traFechaEnvio, that.traFechaEnvio) && Objects.equals(traFechaEntrega, that.traFechaEntrega) && Objects.equals(traDireccionEntrega, that.traDireccionEntrega) && Objects.equals(traEstado, that.traEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traEnvId, pedId, traFechaEnvio, traFechaEntrega, traDireccionEntrega, traEstado);
    }
}
