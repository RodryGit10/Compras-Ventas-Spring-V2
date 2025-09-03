package com.blumbit.ventas.repository;

import org.springframework.data.repository.ListCrudRepository;
import com.blumbit.ventas.entity.Permiso;


// Se extiende de la clase ListCrudRepository paraque tenga metodos de CRUD 
// Para la Tabla "permisos" definido en la Clase Permiso, con ID de tipo Short
public interface PermisoRepository extends ListCrudRepository<Permiso, Short>{

}
