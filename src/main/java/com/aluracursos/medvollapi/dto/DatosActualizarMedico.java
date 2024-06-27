package com.aluracursos.medvollapi.dto;

import com.aluracursos.medvollapi.models.Direccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(
        @NotNull
        Long id,
        String nombre,
        Integer documento,
        Direccion direccion,
        Boolean activo
) {
}
