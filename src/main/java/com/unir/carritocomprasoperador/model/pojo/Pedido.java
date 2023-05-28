package com.unir.carritocomprasoperador.model.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;


@Data
@Entity
@Table(name = "pedido", schema = "carrito_operador", catalog = "")
public class Pedido {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ped_id")
    private Long pedId;
    @Basic
    @Column(name = "dev_id")
    private Integer devId;
    @Basic
    @Column(name = "tra_env_id")
    private Integer traEnvId;
    @Basic
    @Column(name = "cliente_id")
    private int clienteId;
    @Basic
    @Column(name = "ped_fecha")
    private Timestamp pedFecha;
    @Basic
    @Column(name = "ped_estado")
    private Integer pedEstado;


}
