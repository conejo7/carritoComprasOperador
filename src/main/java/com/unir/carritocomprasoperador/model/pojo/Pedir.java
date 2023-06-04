package com.unir.carritocomprasoperador.model.pojo;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pedir", schema = "carrito_operador", catalog = "")
public class Pedir {
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
    @Basic
    @Column(name = "ped_det_producto")
    private String pedDetProducto;


}
