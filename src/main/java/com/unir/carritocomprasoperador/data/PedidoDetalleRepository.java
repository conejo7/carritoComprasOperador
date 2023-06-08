package com.unir.carritocomprasoperador.data;

import com.unir.carritocomprasoperador.model.pojo.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle,Long> {


    List<PedidoDetalle> findAllByPedId(String pedidoId);
}
