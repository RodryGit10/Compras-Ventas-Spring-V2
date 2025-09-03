package com.blumbit.ventas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blumbit.ventas.dto.request.PermisoRequest;
import com.blumbit.ventas.dto.response.PermisoResponse;
import com.blumbit.ventas.entity.Permiso;
import com.blumbit.ventas.repository.PermisoRepository;
import com.blumbit.ventas.service.spec.PermisoService;

@Service
public class PermisoServiceImpl implements PermisoService {

    private final PermisoRepository permisoRepository; // Instanciamos -> Inyeccion de Dependencias

    public PermisoServiceImpl(PermisoRepository permisoRepository) { // Constructor
        this.permisoRepository = permisoRepository;
    }

    @Override
    public List<PermisoResponse> findAllPermisos() { // Obtener Todos los Permisos
        List<PermisoResponse> permisosResponse = new ArrayList();
        List<Permiso> permisosRecuperados = permisoRepository.findAll();
        permisosRecuperados.forEach(permiso -> permisosResponse.add(PermisoResponse.builder()
                .action(permiso.getAction())
                .name(permiso.getName())
                .detail(permiso.getDetail())
                .resource(permiso.getResource())
                .id(permiso.getId())
                .build()));
        return permisosResponse;
    }

    @Override
    public PermisoResponse findPermisoById(Short id) { // Obtener Permiso por ID
        Permiso permiso = permisoRepository.findById(id).orElse(null);
        if (permiso != null) {
            return PermisoResponse.builder()
                    .action(permiso.getAction())
                    .name(permiso.getName())
                    .detail(permiso.getDetail())
                    .resource(permiso.getResource())
                    .id(permiso.getId())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public PermisoResponse crearPermiso(PermisoRequest permisoRequest) { // Crear Permiso
        Permiso permisoToCreate = Permiso.builder()
                .action(permisoRequest.getAction())
                .name(permisoRequest.getName())
                .detail(permisoRequest.getDetail())
                .resource(permisoRequest.getResource())
                .build();
        Permiso permisoCreated = permisoRepository.save(permisoToCreate);
        return PermisoResponse.builder()
                .action(permisoCreated.getAction())
                .name(permisoCreated.getName())
                .detail(permisoCreated.getDetail())
                .resource(permisoCreated.getResource())
                .id(permisoCreated.getId())
                .build();
    }

    @Override
    public PermisoResponse updatePermiso(Short id, PermisoRequest permisoRequest) { // Actualizar Permiso
        Permiso permisoRecuperado = permisoRepository.findById(id).orElse(null);
        if (permisoRecuperado != null) {
            permisoRecuperado.setAction(permisoRequest.getAction());
            permisoRecuperado.setDetail(permisoRequest.getDetail());
            permisoRecuperado.setName(permisoRequest.getName());
            permisoRecuperado.setResource(permisoRequest.getResource());

            Permiso permisoActualizar = permisoRepository.save(permisoRecuperado);
            return PermisoResponse.builder()
                    .action(permisoActualizar.getAction())
                    .name(permisoActualizar.getName())
                    .detail(permisoActualizar.getDetail())
                    .resource(permisoActualizar.getResource())
                    .id(permisoActualizar.getId())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public void deletePermisoById(Short id) {  //Eliminar Un Permiso
        permisoRepository.deleteById(id);
    }

}
