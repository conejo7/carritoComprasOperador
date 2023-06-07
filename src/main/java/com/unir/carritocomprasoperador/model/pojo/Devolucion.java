package com.unir.carritocomprasoperador.model.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Data
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

}
