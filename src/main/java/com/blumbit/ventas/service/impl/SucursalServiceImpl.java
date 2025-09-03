package com.blumbit.ventas.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.blumbit.ventas.entity.Sucursal;
import com.blumbit.ventas.repository.SucursalRepository;
import com.blumbit.ventas.service.spec.SucursalService;

@Service
public class SucursalServiceImpl  implements SucursalService{

    private final SucursalRepository sucursalRepository;  // Instanciacion -> Se invoca a la Calse SucursalRepository para acceder a sus metodos

    public SucursalServiceImpl(SucursalRepository sucursalRepository){ //Constructor
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public List<Sucursal> findAllSucursales() {  //Obtener todos los Sucursales
        return sucursalRepository.findAll();
    }

    @Override
    public List<Sucursal> findByNombreSucursal(String nombre) {  //Obtener un Sucursal por su nombre
        return sucursalRepository.findByNombre(nombre);
    }

    @Override
    public Sucursal findSucursalById(Long id) {  // Obtener Sucursal por su Id
        return sucursalRepository.findById(id).orElse(null);
    }

    @Override
    public Sucursal crearSucursal(Sucursal sucursal) {  // Crear un nuevo Sucursal
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal updateSucursal(Long id, Sucursal sucursal) {  // Actualizar una Sucursal por Id
        Sucursal sucursalRetrieved = sucursalRepository.findById(id).orElse(null);
        if (sucursalRetrieved != null) {
            sucursalRetrieved.setNombre(sucursal.getNombre());
            return sucursalRepository.save(sucursalRetrieved);
        }else{
            return null;
        }
    }

    @Override
    public void deleteSucursalById(Long id) {  // Eliminar una Sucursal por Id
        sucursalRepository.deleteById(id);
    }
    
}
