package com.factura_backend.controller;


import com.factura_backend.entidades.Detalle;
import com.factura_backend.servicios.DetalleServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Se realiza la inyeccion  de las dependecias para asi crear los metodos correspondientes de igual manera
 * se hace la creacion del constructor.
 * Metodos de detalle: listarClientes, guardarCliente, actualizarCliente
 * Se realiza un mapeo de cada metodo
 *
 * @author Luis Manuel
 */

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DetalleController {

    private final DetalleServicio detalleServicio;


    public DetalleController(DetalleServicio detalleServicio) {
        this.detalleServicio = detalleServicio;
    }

    @GetMapping("/detalles")
    public List<Detalle> listarDetalles() {
        return detalleServicio.ConsultarDetalle();
    }

    @PostMapping("/detalle")
    public ResponseEntity<Detalle> guardarDetalle(@RequestBody Detalle detalle) {
        Detalle detalleGuardado = detalleServicio.InsertarDetalle(detalle);
        return ResponseEntity.ok(detalleGuardado);
    }

    @PutMapping("/detalle")
    public Detalle actualizarDetalle(@RequestBody Detalle detalle) {
        return detalleServicio.ActualizarDetalle(detalle);
    }

}
