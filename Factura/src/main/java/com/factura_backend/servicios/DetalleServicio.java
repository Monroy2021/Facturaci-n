package com.factura_backend.servicios;

import com.factura_backend.entidades.Detalle;
import com.factura_backend.excepciones.MensajeExcepcion;
import com.factura_backend.repositorios.DetalleRepositorio;
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
public class DetalleServicio {

    private final DetalleRepositorio detalleRepositorio;

    public DetalleServicio(DetalleRepositorio detalleRepositorio) {
        this.detalleRepositorio = detalleRepositorio;
    }


    public List<Detalle> ConsultarDetalle() {
        return detalleRepositorio.findAll();
    }

    public Detalle InsertarDetalle(Detalle detalle) {
        return detalleRepositorio.save(detalle);
    }

    public Detalle ActualizarDetalle(Detalle detalle) {
        Optional<Detalle> esisteDetalle = detalleRepositorio.findById(detalle.getNumDetalle());

        if (esisteDetalle.isEmpty()) {
            throw new MensajeExcepcion("Detalle no existe", HttpStatus.NOT_FOUND);
        }
        return detalleRepositorio.save(detalle);
    }
}
