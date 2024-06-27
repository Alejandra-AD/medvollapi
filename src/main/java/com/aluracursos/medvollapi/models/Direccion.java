package com.aluracursos.medvollapi.models;

import com.aluracursos.medvollapi.dto.DatosDireccion;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Direccion {
    private String calle;
    private String distrito;
    private String ciudad;
    private Integer numero;
    private String complemento;

    Direccion(DatosDireccion datosDireccion){
        this.calle = datosDireccion.calle();
        this.distrito = datosDireccion.distrito();
        this.ciudad = datosDireccion.ciudad();
        this.numero = datosDireccion.numero();
        this.complemento = datosDireccion.complemento();
    }


    public Direccion datosActualizaDireccion(Direccion datosActualizaDireccion) {
        this.calle = datosActualizaDireccion.calle;
        this.distrito = datosActualizaDireccion.distrito;
        this.ciudad = datosActualizaDireccion.ciudad;
        this.numero = datosActualizaDireccion.numero;
        this.complemento = datosActualizaDireccion.complemento;
        return this;
    }
}
