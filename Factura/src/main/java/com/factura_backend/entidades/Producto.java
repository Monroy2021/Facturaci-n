package com.factura_backend.entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "producto")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    /**
     * Se hace la creacion de la tabla y  entidad ( producto) en a cual se hace una inyeccion de los Getter y Setter y constructor
     * manualmente por medio de la dependecia lombok.
     * De igual manera se hace la relacion a la tabla producto con el OneToMany (Uno a mucho)
     *
     * @author Luis Manuel
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    private String nombre;
    private float precio;
    private String stock;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "producto")
    @JsonBackReference
    private Set<Detalle> detalles = new HashSet<>();
}
