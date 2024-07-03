package com.aluracursos.medvollapi.domain.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter //genera los getter de la clase
@NoArgsConstructor // genera un constructor sin argumentos default
@AllArgsConstructor // genera un constructor con todos los argumentos
@EqualsAndHashCode(of = "id") //compara los hashcode segun el id, si dos objetos son iguales según el método equals, deben tener el mismo valor de hashCode.


public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String clave;

}
