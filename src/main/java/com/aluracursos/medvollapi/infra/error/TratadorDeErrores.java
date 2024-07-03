package com.aluracursos.medvollapi.infra.error;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice

public class TratadorDeErrores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(){
      return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity manejoError400(MethodArgumentNotValidException methodArgumentNotValidException){
        List<DatosErrorValidacion> error = methodArgumentNotValidException.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(error);
    }

    private record DatosErrorValidacion(
            String campo,
            String error
    ){
        public DatosErrorValidacion(FieldError fieldError){
            this(fieldError.getField(),fieldError.getDefaultMessage());
        }
    }

}

