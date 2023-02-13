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
@Table(name = "cliente")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    /**
     * Se hace la creacion de la tabla y  entidad ( cliente) en a cual se hace una inyeccion de los Getter y Setter y constructor
     * manualmente por medio de la dependecia lombok.
     * De igual manera se hace la relacion a la tabla factura con el OneToMany (Uno a mucho)
     *
     * @author Luis Manuel
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteId;

    private String nombre;
    private String apellido;
    private String direccion;
    private Date fecha_nacimiento;
    private String telefono;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cliente")
    @JsonBackReference
    private Set<Factura> facturas = new HashSet<>();


}
