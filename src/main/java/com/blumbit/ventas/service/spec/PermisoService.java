package com.blumbit.ventas.service.spec;

import java.util.List;

import com.blumbit.ventas.dto.request.PermisoRequest;
import com.blumbit.ventas.dto.response.PermisoResponse;

public interface PermisoService {

    List<PermisoResponse> findAllPermisos();

    PermisoResponse findPermisoById(Short id);

    PermisoResponse crearPermiso(PermisoRequest permisoRequest);

    PermisoResponse updatePermiso(Short id, PermisoRequest permisoRequest);

    void deletePermisoById(Short id);

}
