package com.unir.carritocomprasoperador.service;

import com.unir.carritocomprasoperador.data.PedidoRepository;
import com.unir.carritocomprasoperador.model.pojo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getPedidoByEstado() {
        List<Pedido> pedidosList = pedidoRepository.findByPedEstado(1);
        System.out.println(pedidosList);
        return pedidosList.isEmpty() ? null : pedidosList;
    }
}
