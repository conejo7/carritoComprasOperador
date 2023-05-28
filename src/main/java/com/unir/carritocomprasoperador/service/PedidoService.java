package com.unir.carritocomprasoperador.service;

import com.unir.carritocomprasoperador.model.pojo.Pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> getPedidoByEstado();

}
