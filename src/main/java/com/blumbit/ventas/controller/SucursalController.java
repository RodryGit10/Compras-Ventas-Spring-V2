package com.blumbit.ventas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.ventas.entity.Sucursal;
import com.blumbit.ventas.service.spec.SucursalService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sucursal")   // Ruta para acceder al Servicio
public class SucursalController {

    private final SucursalService sucursalService;  //Inyeccion del Servicio
 
    public SucursalController(SucursalService sucursalService) {  //Constructor
        this.sucursalService = sucursalService;
    }

    @GetMapping
    public List<Sucursal> findAllSucursales(){  //Obtener Sucursales
        return sucursalService.findAllSucursales();
    }

    @GetMapping("/{id}")
    public Sucursal findSucursalById(@PathVariable Long id){  //Obtener Sucursal por Id
        return sucursalService.findSucursalById(id);
    }

    @GetMapping("/search")
    public List<Sucursal> findByNombreSucursal(@RequestParam String nombre){  //Obtener por Nombre
        return sucursalService.findByNombreSucursal(nombre);
    }
    
    @PostMapping
    public Sucursal createSucursal(@RequestBody Sucursal sucursal) {  //Crear Sucursal
        return sucursalService.crearSucursal(sucursal);
    }

    @PutMapping("/{id}")
    public Sucursal uptadeSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {  //Actualizar
        return sucursalService.updateSucursal(id, sucursal);
    }

    @DeleteMapping("/{id}")
    public void deleteSucursal(@PathVariable Long id){  //Eiminar
        sucursalService.deleteSucursalById(id);
    }

}
