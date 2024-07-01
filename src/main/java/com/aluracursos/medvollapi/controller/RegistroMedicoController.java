package com.aluracursos.medvollapi.controller;
import com.aluracursos.medvollapi.Repository.MedicoRepository;
import com.aluracursos.medvollapi.dto.DatosActualizarMedico;
import com.aluracursos.medvollapi.dto.DatosEnvioMedicos;
import com.aluracursos.medvollapi.dto.DatosRegistroMedico;
import com.aluracursos.medvollapi.models.Medico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registromedico")
public class RegistroMedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<DatosEnvioMedicos> registroMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico, UriComponentsBuilder uriComponentsBuilder){
        /*System.out.println("\nNombre: " + parametros.nombre() +
                "\nEmail: " + parametros.email()+
                "\nDocumento: "+ parametros.documento()+
                "\nEpecialidad: "+ parametros.especialidad().getEspecialidadJson()+
                "\nDirección: "+ parametros.direccion().calle()+","+parametros.direccion().numero()+
                ". "+parametros.direccion().ciudad().toUpperCase());*/

        //tiene que retornar un 201 mas una url donde se pueda encontrar en este caso el registro del médico
        Medico medico = new Medico(datosRegistroMedico);
        medicoRepository.save(medico);
        DatosEnvioMedicos datosEnvioMedicos= new DatosEnvioMedicos(medico.getNombre(),medico.getEmail(),medico.getDocumento(),
                medico.getEspecialidad());
        URI url = uriComponentsBuilder.path("/registromedico/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(url).body(datosEnvioMedicos);
    }

 /*   @GetMapping
    public List<DatosEnvioMedicos> listaMedicos(){
        return medicoRepository.findAll().stream()
                .map(m->new DatosEnvioMedicos(m.getNombre(),m.getEmail(),m.getDocumento(),m.getEspecialidad()))
                .collect(Collectors.toList());
    }*/

    @GetMapping
    public Page<DatosEnvioMedicos> listaMedicos(@PageableDefault(size = 10,sort = "nombre") Pageable paginacion){
        /*return medicoRepository.findAll(paginacion)
                .map(m->new DatosEnvioMedicos(m.getNombre(),m.getEmail(),m.getDocumento(),m.getEspecialidad()));*/
        return medicoRepository.findByActivoTrue(paginacion)
                .map(m->new DatosEnvioMedicos(m.getNombre(),m.getEmail(),m.getDocumento(),m.getEspecialidad()));
    }


    @Transactional
    @PutMapping
    public ResponseEntity actualizarRegistroMedicos(@RequestBody @Valid DatosActualizarMedico actualizarMedico){
        Medico medico = medicoRepository.getReferenceById(actualizarMedico.id());//crea una instancia de médico segun id
        medico.actualizarDatosMedico(actualizarMedico);
        //lo que recibe del cliente es id de manera obligatoria y el/los parametro/os que desea actualizar
        return ResponseEntity.ok(new DatosActualizarMedico(medico.getId(),medico.getNombre()
                ,medico.getDocumento(),medico.getDireccion(),medico.getActivo()));

    }

 /* version 1: Este es un delete permanente de la base de datos pero no se suele usar para conservar un registro
    @Transactional
    @DeleteMapping
    public void eliminarRegistroMedicos(@RequestBody @Valid DatosActualizarMedico eliminarMedico){
        medicoRepository.deleteById(eliminarMedico.id());
    }*/

    /*
    version2: borrar de la base de datos por pathvariable
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarRegistroMedico2(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medicoRepository.delete(medico);
    }*/

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedicoInactivos(@PathVariable Long id ){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.eliminarMedico();
        return ResponseEntity.noContent().build();

    }



}
