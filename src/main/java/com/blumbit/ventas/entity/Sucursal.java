package com.blumbit.ventas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Indica que esta clase representa una tabla en la base de datos.
@Data  // Ya Tiene directamente cargado Setters y Getters
@AllArgsConstructor  //Constructor con todos los Argumentos
@NoArgsConstructor   // Constructor Vacio
@Table(name = "sucursales") //Anotación JPA que especifica los detalles de la tabla de base de datos.
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;

    
}