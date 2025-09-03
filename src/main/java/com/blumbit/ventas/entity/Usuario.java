package com.blumbit.ventas.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    private String name;
    private String email;
    private String password;

    //Para la tabla intermedia rol_usuario
    @ManyToMany   //Muchos a Muchos
    @JoinTable(   // Relaciona mabas tablas
        name = "rol_usuario",  //Nombre de la Tabla Intermedia
        joinColumns = @JoinColumn(name = "usuario_id"), 
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles;  //El Usuario tendrá una <LISTA> de roles
}