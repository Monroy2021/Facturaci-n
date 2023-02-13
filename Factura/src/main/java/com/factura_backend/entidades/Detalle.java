package com.factura_backend.entidades;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detalle")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Detalle {

    /**
     * Se hace la creacion de la tabla y  entidad ( Detalle) en a cual se hace una inyeccion de los Getter y Setter y constructor
     * manualmente por medio de la dependecia lombok.
     * De igual manera se hace la relaciones  de la tabla factura y producto
     * a la tabla detalle con el ManyToOne (Muchos a uno)
     *
     * @author Luis Manuel
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_detalle")
    private Long numDetalle;

    private Integer cantidad;
    private float precio;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_FACTURA")
    private Factura factura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PRODUCTO")
    private Producto producto;


}
