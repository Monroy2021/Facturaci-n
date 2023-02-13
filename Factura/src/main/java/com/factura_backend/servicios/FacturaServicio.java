package com.factura_backend.servicios;


import com.factura_backend.entidades.Factura;
import com.factura_backend.excepciones.MensajeExcepcion;
import com.factura_backend.repositorios.FacturaRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Se crea los servicios  en la cual se hace la inyeccion de los servicios
 * para tener su enlace con los repositorios  creados anteriormente
 *
 * @author Luis Manuel
 */
@Service
public class FacturaServicio {

    private final FacturaRepositorio facturaRepositorio;

    public FacturaServicio(FacturaRepositorio facturaRepositorio) {
        this.facturaRepositorio = facturaRepositorio;
    }


    public List<Factura> ConsultarFactura() {
        return facturaRepositorio.findAll();
    }

    public Factura InsertarFactura(Factura factura) {
        return facturaRepositorio.save(factura);
    }

    public Factura ActualizarFactura(Factura factura) {
        Optional<Factura> esisteFactura = facturaRepositorio.findById(factura.getNumFactura());

        if (esisteFactura.isEmpty()) {
            throw new MensajeExcepcion("Factura no existe", HttpStatus.NOT_FOUND);
        }
        return facturaRepositorio.save(factura);
    }
}
