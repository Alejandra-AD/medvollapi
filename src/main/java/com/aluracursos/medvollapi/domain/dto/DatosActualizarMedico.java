package com.aluracursos.medvollapi.domain.dto;

import com.aluracursos.medvollapi.domain.models.Direccion;
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
