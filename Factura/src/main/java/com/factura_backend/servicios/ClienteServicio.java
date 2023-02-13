package com.factura_backend.servicios;

import com.factura_backend.entidades.Cliente;
import com.factura_backend.excepciones.MensajeExcepcion;
import com.factura_backend.repositorios.ClienteRepositorio;
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
public class ClienteServicio {

    private final ClienteRepositorio clienteRepositorio;

    public ClienteServicio(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public List<Cliente> ConsultarCliente() {
        return clienteRepositorio.findAll();
    }

    public Cliente InsertarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public Cliente ActualizarCliente(Cliente cliente) {
        Optional<Cliente> esisteCleinte = clienteRepositorio.findById(cliente.getClienteId());

        if (esisteCleinte.isEmpty()) {
            throw new MensajeExcepcion("Cliente no existe", HttpStatus.NOT_FOUND);
        }
        return clienteRepositorio.save(cliente);
    }
}
