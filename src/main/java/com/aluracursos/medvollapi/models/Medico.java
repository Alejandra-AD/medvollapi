package com.aluracursos.medvollapi.models;

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


    public Medico(DatosRegistroMedico parametros){
        this.nombre = parametros.nombre();
        this.email = parametros.email();
        this.telefono = parametros.telefono();
        this.documento = parametros.documento();
        this.especialidad = parametros.especialidad();
        this.direccion = new Direccion(parametros.direccion());
    };
}


