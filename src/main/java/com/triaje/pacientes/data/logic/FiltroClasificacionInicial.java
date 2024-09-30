package com.triaje.pacientes.data.logic;

import java.util.ArrayList;
import java.util.List;

import com.triaje.pacientes.data.entities.Filtro;
import com.triaje.pacientes.data.entities.Paciente;
import com.triaje.pacientes.data.entities.constants.TiposAtencion;

public class FiltroClasificacionInicial implements Filtro<Paciente> {
    private List<Paciente> urgencias = new ArrayList<>();
    private List<Paciente> citasProgramadas = new ArrayList<>();

    @Override
    public List<Paciente> procesar(List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (TiposAtencion.URGENCIAS == paciente.getTipoAtencion()) {
                urgencias.add(paciente);
            } else {
                citasProgramadas.add(paciente);
            }
        }
        return null;
    }

    public List<Paciente> getUrgencias() {
        return urgencias;
    }

    public List<Paciente> getCitasProgramadas() {
        return citasProgramadas;
    }
}
