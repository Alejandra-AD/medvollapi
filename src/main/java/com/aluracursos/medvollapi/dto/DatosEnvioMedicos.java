package com.aluracursos.medvollapi.dto;

import com.aluracursos.medvollapi.models.Especialidad;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosEnvioMedicos(

        String nombre,
        String email,
        Integer documento,
        Especialidad especialidad

) {

}
