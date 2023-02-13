package com.factura_backend.controller;


import com.factura_backend.entidades.Cliente;
import com.factura_backend.servicios.ClienteServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Se realiza la inyeccion  de las dependecias para asi crear los metodos correspondientes de igual manera
 * se hace la creacion del constructor.
 * Metodos de Cliente: listarClientes, guardarCliente, actualizarCliente
 * Se realiza un mapeo de cada metodo
 *
 * @author Luis Manuel
 */

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ClienteController {

    private final ClienteServicio clienteServicio;

    public ClienteController(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return clienteServicio.ConsultarCliente();
    }

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
        Cliente clienteGuardado = clienteServicio.InsertarCliente(cliente);
        return ResponseEntity.ok(clienteGuardado);
    }

    @PutMapping("/cliente")
    public Cliente actualizarCliente(@RequestBody Cliente cliente) {
        return clienteServicio.ActualizarCliente(cliente);
    }


}
