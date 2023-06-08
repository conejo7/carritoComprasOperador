package com.unir.carritocomprasoperador.controller;

import com.unir.carritocomprasoperador.model.pojo.Cliente;
import com.unir.carritocomprasoperador.model.pojo.Pedido;
import com.unir.carritocomprasoperador.model.request.RequestPedido;
import com.unir.carritocomprasoperador.service.ClienteService;
import com.unir.carritocomprasoperador.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Slf4j
public class PedidoController {

    private final PedidoService service;

    private final ClienteService serviceCliente;

    @PostMapping("/savePedido")
    public ResponseEntity<String> savePedido(@RequestBody RequestPedido request) {

        String pedidos = service.createPedido(request);
        if (pedidos != null && "OK".equals(pedidos)) {
            return ResponseEntity.ok(pedidos);
        } else {
            return ResponseEntity.badRequest().body(pedidos);
        }
    }

    @GetMapping("/getPedidos/{pedidoId}")
    public ResponseEntity<Pedido> getOrder(@PathVariable String pedidoId) {
        Pedido pedido = service.getPedidoById(pedidoId);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/getCliente/{clienteId}")
    public ResponseEntity<Cliente> getCliente(@PathVariable String clienteId) {
        Cliente cliente = serviceCliente.getClientebyId(clienteId);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/devolverPedido/{pedidoId}")
    public ResponseEntity<String> devolverPedido(@PathVariable String pedidoId) {
        String pedidoDevuelto = service.devolverPedido(pedidoId);
        if (pedidoDevuelto != null) {
            return ResponseEntity.ok(pedidoDevuelto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
