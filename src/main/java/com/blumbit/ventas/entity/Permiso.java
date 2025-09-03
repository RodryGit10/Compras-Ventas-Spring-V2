package com.blumbit.ventas.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "permisos")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private short id; //32500 aprox

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "resource", length = 100)
    private String resource;

    @Column(name = "action", length = 100)
    private String action;

    @Column(name = "detail")
    private String detail;

    
    //Para la tabla intermedia permiso_rol -> Como ya esta todo tefinido en Rol, 
    //aca simplemente se hace referencia a la Configuracion al campo "permisos"
    @ManyToMany(mappedBy = "permisos")  // en el campo permisos "En ROL" ya esta la configuración -> mappedBy = "permisos"
    private Set<Rol> roles; 

}