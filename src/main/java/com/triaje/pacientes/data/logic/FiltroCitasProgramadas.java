package com.triaje.pacientes.data.logic;

import java.util.ArrayList;
import java.util.List;

import com.triaje.pacientes.data.entities.Filtro;
import com.triaje.pacientes.data.entities.Paciente;

public class FiltroCitasProgramadas implements Filtro<Paciente> {
    private List<Paciente> citasProgramadasPriorizadas = new ArrayList<>();

    @Override
    public List<Paciente> procesar(List<Paciente> pacientes) {
        List<Paciente> ninos = new ArrayList<>();
        List<Paciente> otros = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            if (paciente.getEdad() < 18) {
                ninos.add(paciente);
            } else {
                otros.add(paciente);
            }
        }
        citasProgramadasPriorizadas.addAll(ninos);
        citasProgramadasPriorizadas.addAll(otros);
        return citasProgramadasPriorizadas;
    }

    public List<Paciente> getCitasProgramadasPriorizadas() {
        return citasProgramadasPriorizadas;
    }
}
