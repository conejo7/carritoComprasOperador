package com.unir.carritocomprasoperador.model.response;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseProductSimple {

    private long proSimId;
    private String proSimDescripcion;
    private int proSimCantidad;
    private BigDecimal proSimPrecio;
}
