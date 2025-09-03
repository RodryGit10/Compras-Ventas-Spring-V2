package com.blumbit.ventas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.ventas.dto.request.PermisoRequest;
import com.blumbit.ventas.dto.response.PermisoResponse;
import com.blumbit.ventas.service.spec.PermisoService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController  
@RequestMapping("/permiso")  // Ruta
public class PermisoController {

    private final PermisoService permisoService;  // Instanaciamos la Interfaz PermisoService para acceder a llos metodos CRUD que definimos

    public PermisoController(PermisoService permisoService) {  //Constructor
        this.permisoService = permisoService;
    }

    @GetMapping
    public List<PermisoResponse> findAllPermiso() {  // Obtner Todos los permisos en una lista
        return permisoService.findAllPermisos(); //invocamos el metdodo que definimos en PErmisoService oara Obtner la Lsita de permisos
    }
    
    @GetMapping("/{id}") // Recibe un parametro Id
    public PermisoResponse findPermisoById(@PathVariable Short id) { //Obnetenemos un Permiso por su ID
        return permisoService.findPermisoById(id); //invocamos el metdodo que definimos en PErmisoService oara Obtner por Id
    }

    @PostMapping
    public PermisoResponse createPermiso(@RequestBody PermisoRequest permisoRequest) {
        return permisoService.crearPermiso(permisoRequest);
    }
    
    @PutMapping("/{id}")
    public PermisoResponse apdatePermiso(@PathVariable Short id, @RequestBody PermisoRequest permisoRequest) {

        return permisoService.updatePermiso(id, permisoRequest);
    }

    @DeleteMapping("/{id}")
    public void deletePermiso(@PathVariable Short id){
        permisoService.deletePermisoById(id);
    }
}
