package com.aluracursos.medvollapi.domain.dto;

import com.aluracursos.medvollapi.domain.models.Especialidad;

public record DatosEnvioMedicos(

        String nombre,
        String email,
        Integer documento,
        Especialidad especialidad

) {

}
