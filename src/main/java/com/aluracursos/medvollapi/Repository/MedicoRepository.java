package com.aluracursos.medvollapi.Repository;

import com.aluracursos.medvollapi.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
}
