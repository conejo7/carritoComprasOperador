package com.unir.carritocomprasoperador.facade;

import com.unir.carritocomprasoperador.model.pojo.Pedido;
import com.unir.carritocomprasoperador.model.pojo.PedidoDetalle;
import com.unir.carritocomprasoperador.model.response.ResponseProductSimple;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
//import org.apache.hc.core5.http.HttpEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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

//    public ResponseProductSimple getPedido(String id, ResponseProductSimple responseProductSimple) {
//
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//                //HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
////                return restTemplate.exchange(
////                        "http://localhost:8080/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
//            HttpEntity<ResponseProductSimple> entity = new HttpEntity<>(ResponseProductSimple,headers);
//           // System.out.println(restTemplate.getForObject(String.format(getProductUrl, id), ResponseProductSimple.class));
//            restTemplate.exchange("http://localhost:8080/products/"+id, HttpMethod.PUT, entity, String.class).getBody());
//            return restTemplate.exchange(String.format(getProductUrl, id), HttpMethod.PUT, entity, ResponseProductSimple.class);
//        } catch (HttpClientErrorException e) {
//            log.error("Client Error: {}, Product with ID {}", e.getStatusCode(), id);
//            return null;
//        }
//    }


    public ResponseProductSimple minusAmountProduct(String id) {

        try {

            System.out.println(restTemplate.getForObject(String.format(addProductUrl, id), ResponseProductSimple.class));
            return restTemplate.getForObject(String.format(addProductUrl, id), ResponseProductSimple.class);
        } catch (HttpClientErrorException e) {
            log.error("Client Error: {}, Product with ID {}", e.getStatusCode(), id);
            return null;
        }
    }

}
