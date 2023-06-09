package com.unir.carritocomprasoperador.service;

import com.unir.carritocomprasoperador.model.pojo.Pedido;
import com.unir.carritocomprasoperador.model.request.RequestPedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> getPedidoByEstado();

    String createPedido(RequestPedido request);
    String devolverPedido(String pedidoId);


    Pedido getPedidoById(String pedidoId);

}
