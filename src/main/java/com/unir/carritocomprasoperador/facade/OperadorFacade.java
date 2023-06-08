package com.unir.carritocomprasoperador.facade;

import com.unir.carritocomprasoperador.model.pojo.Pedido;
import com.unir.carritocomprasoperador.model.pojo.PedidoDetalle;
import com.unir.carritocomprasoperador.model.response.ResponseProductSimple;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class OperadorFacade {

    @Value("${getProduct.url}")
    private String getProductUrl;

    @Value("${addProduct.url}")
    private String addProductUrl;

    private final RestTemplate restTemplate;

    public ResponseProductSimple getPedido(String id) {

        try {
            return restTemplate.getForObject(String.format(getProductUrl, id), ResponseProductSimple.class);
        } catch (HttpClientErrorException e) {
            log.error("Client Error: {}, Product with ID {}", e.getStatusCode(), id);
            return null;
        }
    }

    public void minusAmountProduct(String id,Integer cantidad) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ResponseProductSimple responseProductSimple=new ResponseProductSimple();
            responseProductSimple.setProSimCantidad(cantidad);
            HttpEntity<ResponseProductSimple> requestEntity = new HttpEntity<>(responseProductSimple, headers);
            String url= String.format(getProductUrl,id);
            ResponseEntity<ResponseProductSimple> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, ResponseProductSimple.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                log.info("Actualizado");
            } else {
                log.info("La solicitud falló con el código de estado:" +responseEntity.getStatusCode());
            }
        } catch (HttpClientErrorException e) {
            log.error("Client Error: {}, Product with ID {}", e.getStatusCode(), id);
        }
    }

}
