package com.aluracursos.medvollapi.models;

public enum Especialidad {
    ORTOPEDIA("Ortopedia"),
    PEDIATRIA("Pediatría"),

    ;


    private String especialidadJson;

    Especialidad(String especialidadJson){
        this.especialidadJson = especialidadJson;
    }

    private static Especialidad FromString(String text){
        for (Especialidad especialidadJson : Especialidad.values()){
            if(especialidadJson.especialidadJson.equalsIgnoreCase(text)){
                return especialidadJson;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    public String getEspecialidadJson() {
        return especialidadJson;
    }
}

