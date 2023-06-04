package com.unir.carritocomprasoperador.model.request;

import lombok.Data;

@Data
public class DetallePedidoItem{
	private String idProducto;
	private double precioProducto;
	private int cantidadProducto;
}