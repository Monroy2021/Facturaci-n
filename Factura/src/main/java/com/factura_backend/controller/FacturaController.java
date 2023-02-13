package com.factura_backend.controller;

import com.factura_backend.entidades.Detalle;
import com.factura_backend.entidades.Factura;
import com.factura_backend.servicios.DetalleServicio;
import com.factura_backend.servicios.FacturaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FacturaController {

    /**
     * Se realiza la inyeccion  de las dependecias para asi crear los metodos correspondientes de igual manera
     * se hace la creacion del constructor.
     * Metodos de factura: listarClientes, guardarCliente, actualizarCliente
     * Se realiza un mapeo de cada metodo
     *
     * @author Luis Manuel
     */

    private final FacturaServicio facturaServicio;


    public FacturaController(FacturaServicio facturaServicio) {
        this.facturaServicio = facturaServicio;
    }

    @GetMapping("/facturas")
    public List<Factura> listarFacturas() {
        return facturaServicio.ConsultarFactura();
    }

    @PostMapping("/factura")
    public ResponseEntity<Factura> guardarFactura(@RequestBody Factura factura) {
        Factura facturaGuardado = facturaServicio.InsertarFactura(factura);
        return ResponseEntity.ok(facturaGuardado);
    }

    @PutMapping("/factura")
    public Factura actualizarFactura(@RequestBody Factura factura) {
        return facturaServicio.ActualizarFactura(factura);
    }
}
