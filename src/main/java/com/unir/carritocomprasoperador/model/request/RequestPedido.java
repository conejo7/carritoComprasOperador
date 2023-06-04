package com.unir.carritocomprasoperador.model.request;

import java.util.List;

import com.unir.carritocomprasoperador.model.pojo.Cliente;
import lombok.Data;

@Data
public class RequestPedido {
	private List<DetallePedidoItem> detallePedido;
	private String cliente;
}