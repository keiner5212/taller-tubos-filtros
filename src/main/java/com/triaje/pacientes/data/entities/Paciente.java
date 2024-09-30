package com.triaje.pacientes.data.entities;

import com.triaje.pacientes.data.entities.constants.TiposAtencion;

public class Paciente {
    private String nombre;
    private int edad;
    private int gravedad;
    private TiposAtencion tipoAtencion;

    public Paciente(String nombre, int edad, int gravedad, TiposAtencion tipoAtencion) {
        this.nombre = nombre;
        this.edad = edad;
        this.gravedad = gravedad;
        this.tipoAtencion = tipoAtencion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getGravedad() {
        return gravedad;
    }

    public TiposAtencion getTipoAtencion() {
        return tipoAtencion;
    }
}
