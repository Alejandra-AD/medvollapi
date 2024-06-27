package com.aluracursos.medvollapi.controller;
import com.aluracursos.medvollapi.Repository.MedicoRepository;
import com.aluracursos.medvollapi.dto.DatosRegistroMedico;
import com.aluracursos.medvollapi.models.Medico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registromedico")
public class RegistroMedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registroMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){
        /*System.out.println("\nNombre: " + parametros.nombre() +
                "\nEmail: " + parametros.email()+
                "\nDocumento: "+ parametros.documento()+
                "\nEpecialidad: "+ parametros.especialidad().getEspecialidadJson()+
                "\nDirección: "+ parametros.direccion().calle()+","+parametros.direccion().numero()+
                ". "+parametros.direccion().ciudad().toUpperCase());*/

        medicoRepository.save(new Medico(datosRegistroMedico));

    }


}
