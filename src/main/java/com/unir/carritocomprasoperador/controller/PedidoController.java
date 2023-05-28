package com.unir.carritocomprasoperador.controller;

import com.unir.carritocomprasoperador.model.pojo.Pedido;
import com.unir.carritocomprasoperador.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> getProducts() {

        //log.info("headers: {}", headers);
        List<Pedido> pedidos = service.getPedidoByEstado();

        if (pedidos != null) {
            return ResponseEntity.ok(pedidos);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }



}
