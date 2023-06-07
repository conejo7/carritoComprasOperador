package com.unir.carritocomprasoperador.data;

import com.unir.carritocomprasoperador.model.pojo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
