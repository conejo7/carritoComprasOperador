package com.unir.carritocomprasoperador.model.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "pedido_detalle", schema = "carrito_operador", catalog = "")
public class PedidoDetalle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ped_det_id")
    private long pedDetId;
    @Basic
    @Column(name = "ped_id")
    private long pedId;
    @Basic
    @Column(name = "ped_det_catidad")
    private Integer pedDetCatidad;
    @Basic
    @Column(name = "ped_det_descripcion")
    private String pedDetDescripcion;
    @Basic
    @Column(name = "ped_det_producto")
    private String pedDetProducto;


}
