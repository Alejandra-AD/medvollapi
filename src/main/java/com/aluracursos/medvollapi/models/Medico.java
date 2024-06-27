package com.aluracursos.medvollapi.models;

import com.aluracursos.medvollapi.dto.DatosActualizarMedico;
import com.aluracursos.medvollapi.dto.DatosDireccion;
import com.aluracursos.medvollapi.dto.DatosRegistroMedico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter //genera los getter de la clase
@NoArgsConstructor // genera un constructor sin argumentos default
@AllArgsConstructor // genera un constructor con todos los argumentos
@EqualsAndHashCode(of = "id") //compara los hashcode segun el id, si dos objetos son iguales según el método equals, deben tener el mismo valor de hashCode.

public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private Integer telefono;
    private Integer documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;
    private Boolean activo;


    public Medico(DatosRegistroMedico parametros){
        this.nombre = parametros.nombre();
        this.email = parametros.email();
        this.telefono = parametros.telefono();
        this.documento = parametros.documento();
        this.especialidad = parametros.especialidad();
        this.direccion = new Direccion(parametros.direccion());
        this.activo = true;
    };

    public Medico(String nombre, String email, Integer telefono, Integer documento, Especialidad especialidad, DatosDireccion direccion) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.documento = documento;
        this.especialidad = especialidad;
        this.direccion = new Direccion(direccion);
    }

    public void actualizarDatosMedico(DatosActualizarMedico datosActualizarMedico){
        if(datosActualizarMedico.nombre() != null){
            this.nombre = datosActualizarMedico.nombre();
        }
        if(datosActualizarMedico.documento() != null){
            this.documento = datosActualizarMedico.documento();
        }
        if (datosActualizarMedico.direccion() != null){
            this.direccion = direccion.datosActualizaDireccion(datosActualizarMedico.direccion());
        }
        if(datosActualizarMedico.activo() != null && datosActualizarMedico.activo().booleanValue() == true){
            this.activo = datosActualizarMedico.activo();
        }
    }


    public void eliminarMedico() {
        this.activo = false;
    }
}


