package com.aluracursos.medvollapi.controller;

import com.aluracursos.medvollapi.domain.Repository.UsuarioRepository;
import com.aluracursos.medvollapi.domain.dto.DatosLoginUsuario;
import com.aluracursos.medvollapi.domain.dto.DatosTokenUsuario;
import com.aluracursos.medvollapi.domain.models.Usuario;
import com.aluracursos.medvollapi.infra.security.TokenService;
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

    @Autowired
    private TokenService tokenService;

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
    Authentication tokenAuth = new UsernamePasswordAuthenticationToken(datosLoginUsuario.login(),datosLoginUsuario.clave());
    var usuarioAuth = authenticationManager.authenticate(tokenAuth);
    var tokenJWT = tokenService.generarToken((Usuario) usuarioAuth.getPrincipal());
    return ResponseEntity.ok(new DatosTokenUsuario(tokenJWT));
}

}
