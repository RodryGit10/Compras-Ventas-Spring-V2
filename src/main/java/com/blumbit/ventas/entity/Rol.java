package com.blumbit.ventas.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity  // Indica que "Rol" es una entidad que se persistirá en la base de datos. (para apllicar metodos HTTP: guardar, obtener, eliminar, actualizar)
@Getter  //Genera métodos como getId() y getName().
@Setter // Genera métodos como setId(Long id) y setName(String name).
@AllArgsConstructor // Genera un constructor como public Role(Long id, String name).
@Table(name = "roles") //Especifica que la entidad se mapeará a la tabla "roles".
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nombre", nullable=false, length=100)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    //Para la tabla intermedia permiso_rol
    @ManyToMany   //Muchos a Muchos
    @JoinTable(   // Relaciona mabas tablas
        name = "permiso_rol",  //Nombre de la Tabla Intermedia
        joinColumns = @JoinColumn(name = "rol_id"), 
        inverseJoinColumns = @JoinColumn(name = "permiso_id")
    )
    private Set<Permiso> permisos;  //El Rol tendrá una <LISTA> de permisos

    
    //Para la Tabla Intermedia "rol_usuario"
    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;



    
    // Constructores, getters y setters

    // // Constructores
    // public Rol() {
    // }

    // public Rol(String nombre, String descripcion) {
    //     this.nombre = nombre;
    //     this.descripcion = descripcion;
    // }

    // // Getters y Setters
    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getNombre() {
    //     return nombre;
    // }

    // public void setNombre(String nombre) {
    //     this.nombre = nombre;
    // }

    // public String getDescripcion() {
    //     return descripcion;
    // }

    // public void setDescripcion(String descripcion) {
    //     this.descripcion = descripcion;
    // }

}
