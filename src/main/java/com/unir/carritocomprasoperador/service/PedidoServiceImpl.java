package com.unir.carritocomprasoperador.service;

import com.unir.carritocomprasoperador.data.PedidoDetalleRepository;
import com.unir.carritocomprasoperador.data.PedidoRepository;
import com.unir.carritocomprasoperador.facade.OperadorFacade;
import com.unir.carritocomprasoperador.model.pojo.Pedido;
import com.unir.carritocomprasoperador.model.pojo.PedidoDetalle;
import com.unir.carritocomprasoperador.model.request.DetallePedidoItem;
import com.unir.carritocomprasoperador.model.request.RequestPedido;
import com.unir.carritocomprasoperador.model.request.RequestPedir;
import com.unir.carritocomprasoperador.model.response.ResponseProductSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private OperadorFacade operadorFacade;
    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Override
    public List<Pedido> getPedidoByEstado() {
        List<Pedido> pedidosList = pedidoRepository.findByPedEstado(1);
        System.out.println(pedidosList);
        return pedidosList.isEmpty() ? null : pedidosList;
    }


    @Override
    public String createPedido(RequestPedido request) {

//        Pedido pedido = new Pedido();
//        pedido.setClienteId(Integer.parseInt(request.getCliente()));
//        pedido.setPedFecha(LocalDate.now());
//        Pedido finalPedido = pedidoRepository.save(pedido);
//        List<ResponseProductSimple> products1 = request.getDetallePedido().stream()
//                .map(elem -> {
//                    ResponseProductSimple responseProductSimple = operadorFacade.getPedido(elem.getIdProducto());
//                    if (responseProductSimple.getProSimCantidad()>0){
//                        PedidoDetalle pedidoDetalle = new PedidoDetalle();
//                        pedidoDetalle.setPedId(finalPedido.getPedId());
//                        pedidoDetalle.setPedDetCatidad(elem.getCantidadProducto());
//                        pedidoDetalleRepository.save(pedidoDetalle);
//                        return responseProductSimple;
//                    }else {
//                        return null;
//                    }
//                })
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());

        List<ResponseProductSimple> products1 = new ArrayList<>();
        Pedido pedido = new Pedido();
        pedido.setClienteId(Integer.parseInt(request.getCliente()));
        pedido.setPedFecha(LocalDate.now());
        Pedido finalPedido = pedidoRepository.save(pedido);
        for (DetallePedidoItem elem : request.getDetallePedido()) {
            ResponseProductSimple responseProductSimple = operadorFacade.getPedido(elem.getIdProducto());

                PedidoDetalle pedidoDetalle = new PedidoDetalle();
                pedidoDetalle.setPedId(pedido.getPedId());
                pedidoDetalle.setPedDetCatidad(elem.getCantidadProducto());
                pedidoDetalleRepository.save(pedidoDetalle);


            if (responseProductSimple != null && responseProductSimple.getProSimCantidad()>0) {
                products1.add(responseProductSimple);
            }
        }

        System.out.println("products"+products1.toString());
        return products1.size() == request.getDetallePedido().size() ? "OK" : "NO HAY STOCK PARA EL PRODUCTO";
    }



}
