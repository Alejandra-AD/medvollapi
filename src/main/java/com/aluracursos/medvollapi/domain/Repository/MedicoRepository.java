package com.aluracursos.medvollapi.domain.Repository;


import com.aluracursos.medvollapi.domain.models.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
    Page <Medico> findByActivoTrue(Pageable paginacion);
}
