package com.unir.carritocomprasoperador.model.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
public class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cliente_id")
    private int clienteId;
    @Basic
    @Column(name = "cli_nombre")
    private String cliNombre;
    @Basic
    @Column(name = "cli_apellido")
    private String cliApellido;
    @Basic
    @Column(name = "cli_telefono")
    private String cliTelefono;
    @Basic
    @Column(name = "cli_direccion")
    private String cliDireccion;
    @Basic
    @Column(name = "cli_correo")
    private String cliCorreo;
    @Basic
    @Column(name = "cli_fecha_nacimiento")
    private Timestamp cliFechaNacimiento;
    @Basic
    @Column(name = "cli_cedula")
    private String cliCedula;


}
