package com.blumbit.ventas.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data // Ya Tiene directamente cargado Setters y Getters
@Entity // Indica que esta clase representa una tabla en la base de datos.Spring Boot gestionará automáticamente la persistencia de esta entidad.
@Table(name = "sucursal_usuario") //Anotación JPA que especifica los detalles de la tabla de base de datos.
public class SucursalUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne  //Muchos a Uno -> Tabla Intemedia = muchos - A - Tablas Usuario = Uno
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    private LocalDate fechaCreacion;
}
