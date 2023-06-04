package com.unir.carritocomprasoperador.controller;

import com.unir.carritocomprasoperador.model.exception.ApiError;
import com.unir.carritocomprasoperador.model.pojo.Pedido;
import com.unir.carritocomprasoperador.model.request.RequestPedido;
import com.unir.carritocomprasoperador.model.request.RequestPedir;
import com.unir.carritocomprasoperador.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;



@RestController
@RequiredArgsConstructor
@Slf4j
public class PedidoController {

    private final PedidoService service;

    @GetMapping("/test")
    public String hola() {
        //logger.info("Funcionando");
        return "test2";
    }

    @GetMapping("/savePedido")
    public ResponseEntity<String> savePedido(@RequestBody RequestPedido request) {

        String pedidos = service.createPedido(request);
        String sErrorMsg = "No hay stock";
        if (pedidos != null && "OK".equals(pedidos)) {
            return ResponseEntity.ok(pedidos);
        } else {
            return ResponseEntity.badRequest().body(sErrorMsg);
        }
    }

    @PostMapping("/getPedidos")
    public ResponseEntity<String> createOrder(@RequestBody RequestPedido request) {

        String result = service.createPedido(request);

        if(request != null && "OK".equals(result)) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }



}
