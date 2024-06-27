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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registromedico")
public class RegistroMedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registroMedico(@RequestBody @Valid List<DatosRegistroMedico> datosRegistroMedico){
        /*System.out.println("\nNombre: " + parametros.nombre() +
                "\nEmail: " + parametros.email()+
                "\nDocumento: "+ parametros.documento()+
                "\nEpecialidad: "+ parametros.especialidad().getEspecialidadJson()+
                "\nDirección: "+ parametros.direccion().calle()+","+parametros.direccion().numero()+
                ". "+parametros.direccion().ciudad().toUpperCase());*/

        datosRegistroMedico.stream()
                .forEach(m->medicoRepository
                        .save(new Medico(m.nombre(),m.email(),m.telefono(),m.documento(),m.especialidad(),m.direccion())));

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
    public void actualizarRegistroMedicos(@RequestBody @Valid DatosActualizarMedico actualizarMedico){
        Medico medico = medicoRepository.getReferenceById(actualizarMedico.id());//crea una instancia de médico segun id
        medico.actualizarDatosMedico(actualizarMedico);//llama a metodo en médico para actualizar los datos y envia como parametro lo que recibe del cliente.
        //lo que recibe del cliente es id de manera obligatoria y el/los parametro/os que desea actualizar

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
    public void eliminarMedicoInactivos(@PathVariable Long id ){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.eliminarMedico();

    }



}
