package com.aluracursos.medvollapi.dto;

public record DatosDireccion(
        String calle,
        String distrito,
        String ciudad,
        Integer numero,
        String complemento
) {
}
