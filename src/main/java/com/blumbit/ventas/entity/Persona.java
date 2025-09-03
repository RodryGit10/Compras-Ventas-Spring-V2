package com.blumbit.ventas.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
// @Entity: ->  Anotación que marca esta clase como una entidad JPA.
 * Indica que esta clase representa una tabla en la base de datos.
 * Spring Boot gestionará automáticamente la persistencia de esta entidad.
 */
@Entity  
@Table(name = "personas") // Anotación JPA que especifica los detalles de la tabla de base de datos.
public class Persona { // para clase -> PascalCase
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="per_nombres", length=100, nullable=false) //en la tabla de la BD se creara como per_nombres
    private String nombres;

    @Column(name="per_apellidos", length=100, nullable=false)
    private String apellidos;

    @Column(name="fecha_nacimiento")
    private LocalDate fechaNacimiento;  //-> camelCase -> en tabla de BD = fecha_nacimiento = snak_case

    private String genero;

    private String telefono;

    private String direccion;

    private String docuementoIdentidad;

    private String tipoDocumento;

    private String nacionalidad;

    @OneToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
}