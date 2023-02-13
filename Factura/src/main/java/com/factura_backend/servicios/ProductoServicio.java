package com.factura_backend.servicios;

import com.factura_backend.entidades.Producto;
import com.factura_backend.excepciones.MensajeExcepcion;
import com.factura_backend.repositorios.ProductoRepositorio;
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
public class ProductoServicio {

    private final ProductoRepositorio productoRepositorio;

    public ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }


    public List<Producto> ConsultarProducto() {
        return productoRepositorio.findAll();
    }

    public Producto InsertarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public Producto ActualizarProducto(Producto producto) {
        Optional<Producto> esisteProducto = productoRepositorio.findById(producto.getIdProducto());

        if (esisteProducto.isEmpty()) {
            throw new MensajeExcepcion("Producto no existe", HttpStatus.NOT_FOUND);
        }
        return productoRepositorio.save(producto);
    }
}
