package com.triaje.pacientes.data.logic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

import com.triaje.pacientes.data.entities.Filtro;
import com.triaje.pacientes.data.entities.Paciente;

public class FiltroUrgencias implements Filtro<Paciente> {
    private List<Paciente> adultosMayores = new ArrayList<>();
    private List<Paciente> urgenciasOrdenadas = new ArrayList<>();

    @Override
    public List<Paciente> procesar(List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getEdad() >= 65) {
                adultosMayores.add(paciente);
            } else {
                urgenciasOrdenadas.add(paciente);
            }
        }
        urgenciasOrdenadas = urgenciasOrdenadas.stream()
                .sorted(Comparator.comparingInt(Paciente::getGravedad).reversed())
                .collect(Collectors.toList());
        return null;
    }

    public List<Paciente> getAdultosMayores() {
        return adultosMayores;
    }

    public List<Paciente> getUrgenciasOrdenadas() {
        return urgenciasOrdenadas;
    }
}