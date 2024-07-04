package com.aluracursos.medvollapi.domain.models;


import com.aluracursos.medvollapi.domain.dto.DatosLoginUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter //genera los getter de la clase
@NoArgsConstructor // genera un constructor sin argumentos default
@AllArgsConstructor // genera un constructor con todos los argumentos
@EqualsAndHashCode(of = "id") //compara los hashcode segun el id, si dos objetos son iguales según el método equals, deben tener el mismo valor de hashCode.


public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String clave;

    public Usuario(DatosLoginUsuario datosLoginUsuario){
        this.login = datosLoginUsuario.login();
        this.clave = datosLoginUsuario.clave();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
