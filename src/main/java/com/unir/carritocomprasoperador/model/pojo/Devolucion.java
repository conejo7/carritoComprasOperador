package com.unir.carritocomprasoperador.model.pojo;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Devolucion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dev_id")
    private int devId;
    @Basic
    @Column(name = "ped_id")
    private int pedId;
    @Basic
    @Column(name = "dev_descripcion")
    private String devDescripcion;
    @Basic
    @Column(name = "dev_fecha")
    private Timestamp devFecha;
    @Basic
    @Column(name = "dev_estado")
    private Byte devEstado;

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public int getPedId() {
        return pedId;
    }

    public void setPedId(int pedId) {
        this.pedId = pedId;
    }

    public String getDevDescripcion() {
        return devDescripcion;
    }

    public void setDevDescripcion(String devDescripcion) {
        this.devDescripcion = devDescripcion;
    }

    public Timestamp getDevFecha() {
        return devFecha;
    }

    public void setDevFecha(Timestamp devFecha) {
        this.devFecha = devFecha;
    }

    public Byte getDevEstado() {
        return devEstado;
    }

    public void setDevEstado(Byte devEstado) {
        this.devEstado = devEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devolucion that = (Devolucion) o;
        return devId == that.devId && pedId == that.pedId && Objects.equals(devDescripcion, that.devDescripcion) && Objects.equals(devFecha, that.devFecha) && Objects.equals(devEstado, that.devEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(devId, pedId, devDescripcion, devFecha, devEstado);
    }
}
