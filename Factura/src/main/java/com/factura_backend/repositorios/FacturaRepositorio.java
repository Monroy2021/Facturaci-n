package com.factura_backend.repositorios;

import com.factura_backend.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Se crea los Repositorios en la cual se hace la inyeccion con el extends
 *
 * @author Luis Manuel
 */
@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
}
