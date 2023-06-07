package com.unir.carritocomprasoperador.controller;

import com.unir.carritocomprasoperador.model.exception.ApiError;
import com.unir.carritocomprasoperador.model.pojo.Cliente;
import com.unir.carritocomprasoperador.model.pojo.Pedido;
import com.unir.carritocomprasoperador.model.request.RequestPedido;
import com.unir.carritocomprasoperador.model.request.RequestPedir;
import com.unir.carritocomprasoperador.service.ClienteService;
import com.unir.carritocomprasoperador.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;



@RestController
@RequiredArgsConstructor
@Slf4j
public class PedidoController {

    private final PedidoService service;

    private final ClienteService serviceCliente;

    @GetMapping("/test")
    public String hola() {
        //logger.info("Funcionando");
        return "test2";
    }

    @PostMapping("/savePedido")
    public ResponseEntity<String> savePedido(@RequestBody RequestPedido request) {

        String pedidos = service.createPedido(request);
        String sErrorMsg = "No hay stock";
        if (pedidos != null && "OK".equals(pedidos)) {
            return ResponseEntity.ok(pedidos);
        } else {
            return ResponseEntity.badRequest().body(sErrorMsg);
        }
    }

    @GetMapping("/getPedidos/{pedidoId}")
    public ResponseEntity<Pedido> getOrder(@PathVariable String pedidoId) {
        log.info("Request received for pedido {}", pedidoId);
        Pedido pedido = service.getPedidoById(pedidoId);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/getCliente/{clienteId}")
    public ResponseEntity<Cliente> getCliente(@PathVariable String clienteId) {
        log.info("Request received for pedido {}", clienteId);
        Cliente cliente = serviceCliente.getClientebyId(clienteId);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
