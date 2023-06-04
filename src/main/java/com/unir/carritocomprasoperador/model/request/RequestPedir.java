package com.unir.carritocomprasoperador.model.request;

import lombok.Data;

@Data
public class RequestPedir{
	private String pedido;
	private String idProducto;
	private double precioProducto;
	private int cantidadProducto;
}