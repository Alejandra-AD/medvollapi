package com.aluracursos.medvollapi.domain.models;

public enum Especialidad {
    ORTOPEDIA("Ortopedia"),
    PEDIATRIA("Pediatría"),
    CARDIOLOGIA("Cardiología"),
    NEUROLOGIA("Neurología"),
    GINECOLOGIA("Ginecología"),
    DERMATOLOGIA("Dermatología"),
    UROLOGIA("Urología"),
    GENETICA("Genética"),
    NUTRICION("Nutrición"),
    PSIQUIATRIA("Psiquiatría"),
    TOXICOLOGIA("Toxicología"),
    GASTROENTEROLOGIA("Gastroenterología"),
    ENDOCRINOLOGIA("Endocrinología"),
    GERIATRIA("Geriatría"),
    HEMATOLOGIA("Hematología"),
    INFECTOLOGIA("Infectología"),
    OFTALMOLOGIA("Oftalmología"),
    ANIMAL_SERVICIO("Animal de servicio"),
    TRAUMATOLOGIA("Traumatología"),
    ALERGOLOGIA("Alergología"),
    RADIOLOGIA("Radiología"),
    ADMINISTRACION("Administración")
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

