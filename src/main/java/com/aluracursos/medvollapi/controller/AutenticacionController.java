package com.aluracursos.medvollapi.controller;

import com.aluracursos.medvollapi.domain.Repository.UsuarioRepository;
import com.aluracursos.medvollapi.domain.dto.DatosLoginUsuario;
import com.aluracursos.medvollapi.domain.models.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    /*@Autowired
    private UsuarioRepository usuarioRepository;*/

    @Autowired
    private AuthenticationManager authenticationManager;

/*@PostMapping
  public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosLoginUsuario datosLoginUsuario, UriComponentsBuilder uriComponentsBuilder){
    var usuario = new Usuario(datosLoginUsuario);
    usuarioRepository.save(usuario);
    var datosUsuarioRegistrado = new DatosLoginUsuario(usuario.getLogin(), usuario.getClave());
    URI url = uriComponentsBuilder.path("/login/{id}").buildAndExpand(usuario.getId()).toUri();
    return ResponseEntity.created(url).body(datosUsuarioRegistrado);
    }*/

    @PostMapping
    public ResponseEntity autenticacionUsuario (@RequestBody @Valid DatosLoginUsuario datosLoginUsuario){
    Authentication token = new UsernamePasswordAuthenticationToken(datosLoginUsuario.login(),datosLoginUsuario.clave());
    authenticationManager.authenticate(token);
    return ResponseEntity.ok().build();
}

}
