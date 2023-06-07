package com.unir.carritocomprasoperador.data;

import com.unir.carritocomprasoperador.model.pojo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {

    List<Pedido> findByPedEstado(Integer estado);

    //Pedido findByPedId(String pedidoId);


}
