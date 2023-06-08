package com.unir.carritocomprasoperador.service;

import com.unir.carritocomprasoperador.data.DevolucionRepository;
import com.unir.carritocomprasoperador.data.PedidoDetalleRepository;
import com.unir.carritocomprasoperador.data.PedidoRepository;
import com.unir.carritocomprasoperador.facade.OperadorFacade;
import com.unir.carritocomprasoperador.model.pojo.Devolucion;
import com.unir.carritocomprasoperador.model.pojo.Pedido;
import com.unir.carritocomprasoperador.model.pojo.PedidoDetalle;
import com.unir.carritocomprasoperador.model.request.DetallePedidoItem;
import com.unir.carritocomprasoperador.model.request.RequestPedido;
import com.unir.carritocomprasoperador.model.response.ResponseProductSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private OperadorFacade operadorFacade;
    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;
    @Autowired
    private DevolucionRepository devolucionRepository;

    @Override
    public List<Pedido> getPedidoByEstado() {
        List<Pedido> pedidosList = pedidoRepository.findByPedEstado(1);
        return pedidosList.isEmpty() ? null : pedidosList;
    }


    @Override
    public String createPedido(RequestPedido request) {
        List<ResponseProductSimple> products1 = new ArrayList<>();
        List<String> productsSinStock = new ArrayList<>();
        Pedido pedido = new Pedido();
        pedido.setClienteId(Integer.parseInt(request.getCliente()));
        pedido.setPedFecha(LocalDate.now());
        Pedido finalPedido = pedidoRepository.save(pedido);
        for (DetallePedidoItem elem : request.getDetallePedido()) {
            ResponseProductSimple productSimple = operadorFacade.getPedido(elem.getIdProducto());
            PedidoDetalle pedidoDetalle = new PedidoDetalle();
            pedidoDetalle.setPedId(finalPedido.getPedId());
            pedidoDetalle.setPedDetCatidad(elem.getCantidadProducto());
            pedidoDetalle.setPedDetProducto(elem.getIdProducto());
            pedidoDetalle.setPedDetDescripcion("todo ok");
            pedidoDetalleRepository.save(pedidoDetalle);
            if (productSimple != null) {
                if (productSimple.getProSimCantidad() > 0 && (productSimple.getProSimCantidad() - elem.getCantidadProducto()) >= 0) {
                    products1.add(productSimple);
                    operadorFacade.minusAmountProduct(elem.getIdProducto(), productSimple.getProSimCantidad() - elem.getCantidadProducto());
                }else {
                    productsSinStock.add(String.valueOf(productSimple.getProSimId()));
                }
            }
        }
        return products1.size() == request.getDetallePedido().size() ? "OK" : "NO HAY STOCK PARA EL PRODUCTO CON ID" + productsSinStock.toString();
    }

    @Override
    public Pedido getPedidoById(String pedidoId) {
        return pedidoRepository.findById(Long.valueOf(pedidoId)).orElse(null);
    }

    @Override
    public String devolverPedido(String pedidoId) {
        Devolucion devolucion = new Devolucion();
        devolucion.setPedId(Integer.parseInt(pedidoId));
        devolucion.setDevFecha(LocalDate.now());
        devolucion.setDevEstado(0);
        List<PedidoDetalle> pedidoDetalle = pedidoDetalleRepository.findAllByPedId(pedidoId);
        pedidoDetalle.forEach(elem -> {
            ResponseProductSimple productSimple = operadorFacade.getPedido(elem.getPedDetProducto());
            operadorFacade.minusAmountProduct(String.valueOf(productSimple.getProSimId()), productSimple.getProSimCantidad() + elem.getPedDetCatidad());
        });
        devolucionRepository.save(devolucion);
        return "ok";
    }


}
