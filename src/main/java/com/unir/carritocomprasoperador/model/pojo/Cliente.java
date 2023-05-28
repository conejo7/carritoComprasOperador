package com.unir.carritocomprasoperador.model.pojo;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

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

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliApellido() {
        return cliApellido;
    }

    public void setCliApellido(String cliApellido) {
        this.cliApellido = cliApellido;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliCorreo() {
        return cliCorreo;
    }

    public void setCliCorreo(String cliCorreo) {
        this.cliCorreo = cliCorreo;
    }

    public Timestamp getCliFechaNacimiento() {
        return cliFechaNacimiento;
    }

    public void setCliFechaNacimiento(Timestamp cliFechaNacimiento) {
        this.cliFechaNacimiento = cliFechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return clienteId == cliente.clienteId && Objects.equals(cliNombre, cliente.cliNombre) && Objects.equals(cliApellido, cliente.cliApellido) && Objects.equals(cliTelefono, cliente.cliTelefono) && Objects.equals(cliDireccion, cliente.cliDireccion) && Objects.equals(cliCorreo, cliente.cliCorreo) && Objects.equals(cliFechaNacimiento, cliente.cliFechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, cliNombre, cliApellido, cliTelefono, cliDireccion, cliCorreo, cliFechaNacimiento);
    }
}
