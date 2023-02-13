package com.factura_backend.entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "factura")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    /**
     * Se hace la creacion de la tabla y  entidad ( factura) en a cual se hace una inyeccion de los Getter y Setter y constructor
     * manualmente por medio de la dependecia lombok.
     * De igual manera se hace la relacion a la tabla factura con el OneToMany (Uno a mucho)
     *
     * @author Luis Manuel
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_factura")
    private Long numFactura;

    private Date fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "factura")
    @JsonBackReference
    private Set<Detalle> detalles = new HashSet<>();

}
