package com.blumbit.ventas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PermisoRequest {

    private String name;

    private String resource;

    private String action;

    private String detail;
}
