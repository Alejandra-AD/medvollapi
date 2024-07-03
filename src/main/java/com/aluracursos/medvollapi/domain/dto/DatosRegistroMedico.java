package com.aluracursos.medvollapi.domain.dto;

import com.aluracursos.medvollapi.domain.models.Especialidad;
import jakarta.validation.constraints.*;

public record DatosRegistroMedico(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,

        /*@NotBlank , es solo para String*/
        @NotNull
        /*@Pattern(regexp = "\\d{9}") //Pattern utiliza un expresión regular (regexp), solo para strings, para determinar que este argumento contenga 9 digitos(\\d)*/
        @Digits(integer = 9,fraction = 0 , message = "El documento debe ser de 9 dígitos")
        Integer telefono,

        @NotNull
        /*@Pattern(regexp ="\\d{4,6}")*/
        Integer documento,
        @NotNull
        Especialidad especialidad,

        @NotNull//dado que es un objeto puede llegar null no en blanco**
        DatosDireccion direccion
) {

}
