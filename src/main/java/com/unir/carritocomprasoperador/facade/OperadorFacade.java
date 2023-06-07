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

            System.out.println(restTemplate.getForObject(String.format(getProductUrl, id), ResponseProductSimple.class));
            return restTemplate.getForObject(String.format(getProductUrl, id), ResponseProductSimple.class);
        } catch (HttpClientErrorException e) {
            log.error("Client Error: {}, Product with ID {}", e.getStatusCode(), id);
            return null;
        }
    }

    public ResponseEntity minusAmountProduct(String id) {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);


            ResponseProductSimple responseProductSimple=new ResponseProductSimple();
            HttpEntity<ResponseProductSimple> requestEntity = new HttpEntity<ResponseProductSimple>(responseProductSimple, headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(addProductUrl, HttpMethod.PUT, requestEntity, String.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                String responseBody = responseEntity.getBody();
                System.out.println("Respuesta: " + responseBody);
            } else {
                System.out.println("La solicitud falló con el código de estado: " + responseEntity.getStatusCodeValue());
            }
            return responseEntity;
            //return restTemplate.exchange(String.format(addProductUrl, id), ResponseProductSimple.class);
        } catch (HttpClientErrorException e) {
            log.error("Client Error: {}, Product with ID {}", e.getStatusCode(), id);
            return null;
        }
    }

}
