package com.unir.carritocomprasoperador.service;

import com.unir.carritocomprasoperador.data.ClienteRepository;
import com.unir.carritocomprasoperador.data.PedidoRepository;
import com.unir.carritocomprasoperador.model.pojo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getClientebyId(String clienteId){
        return   clienteRepository.findById(Long.valueOf(clienteId)).orElse(null);
    }
}
