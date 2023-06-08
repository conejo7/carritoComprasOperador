package com.unir.carritocomprasoperador.data;

import com.unir.carritocomprasoperador.model.pojo.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevolucionRepository extends JpaRepository<Devolucion,Long> {
}
