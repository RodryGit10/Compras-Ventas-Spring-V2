package com.blumbit.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blumbit.ventas.entity.Rol;


// Se extiende de la clase JpaRepository para que tenga metodos de CRUD y ademas PAGINACION
// Para la Tabla "roles" definido en la Clase Rol, con ID de tipo Long
public interface RolRepository extends JpaRepository<Rol, Long>{

}
