package com.factura_backend.controller;


import com.factura_backend.entidades.Producto;
import com.factura_backend.servicios.ProductoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductoController {

    /**
     * Se realiza la inyeccion  de las dependecias para asi crear los metodos correspondientes de igual manera
     * se hace la creacion del constructor.
     * Metodos de producto: listarClientes, guardarCliente, actualizarCliente
     * Se realiza un mapeo de cada metodo
     *
     * @author Luis Manuel
     */

    private final ProductoServicio productoServicio;


    public ProductoController(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return productoServicio.ConsultarProducto();
    }

    @PostMapping("/producto")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        Producto productoGuardado = productoServicio.InsertarProducto(producto);
        return ResponseEntity.ok(productoGuardado);
    }

    @PutMapping("/producto")
    public Producto actualizarProducto(@RequestBody Producto Producto) {
        return productoServicio.ActualizarProducto(Producto);
    }
}
