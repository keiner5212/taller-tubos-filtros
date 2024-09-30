package com.triaje.pacientes;

import java.util.Arrays;
import java.util.List;

import com.triaje.pacientes.data.entities.Paciente;
import com.triaje.pacientes.data.entities.constants.TiposAtencion;
import com.triaje.pacientes.data.logic.FiltroCitasProgramadas;
import com.triaje.pacientes.data.logic.FiltroClasificacionInicial;
import com.triaje.pacientes.data.logic.FiltroUrgencias;

public class Main {
        public static void main(String[] args) {
                List<Paciente> pacientes = Arrays.asList(
                                new Paciente("Juan", 70, 5, TiposAtencion.URGENCIAS),
                                new Paciente("Ana", 30, 3, TiposAtencion.URGENCIAS),
                                new Paciente("Luis", 10, 2, TiposAtencion.CITAS_PROGRAMADAS),
                                new Paciente("Maria", 40, 4, TiposAtencion.CITAS_PROGRAMADAS),
                                new Paciente("Carlos", 80, 4, TiposAtencion.URGENCIAS),
                                new Paciente("Elena", 25, 5, TiposAtencion.URGENCIAS),
                                new Paciente("Miguel", 5, 1, TiposAtencion.CITAS_PROGRAMADAS),
                                new Paciente("Sofia", 17, 2, TiposAtencion.CITAS_PROGRAMADAS),
                                new Paciente("Pedro", 50, 3, TiposAtencion.URGENCIAS),
                                new Paciente("Lucia", 10, 3, TiposAtencion.CITAS_PROGRAMADAS),
                                new Paciente("Roberto", 65, 2, TiposAtencion.URGENCIAS),
                                new Paciente("Laura", 30, 4, TiposAtencion.CITAS_PROGRAMADAS));

                FiltroClasificacionInicial filtroInicial = new FiltroClasificacionInicial();
                filtroInicial.procesar(pacientes);

                FiltroUrgencias filtroUrgencias = new FiltroUrgencias();
                filtroUrgencias.procesar(filtroInicial.getUrgencias());

                FiltroCitasProgramadas filtroCitas = new FiltroCitasProgramadas();
                filtroCitas.procesar(filtroInicial.getCitasProgramadas());

                System.out.println("Urgencias Adultos Mayores: " +
                                filtroUrgencias.getAdultosMayores().stream().map(Paciente::getNombre).toList());
                System.out.println("Urgencias Ordenadas por Prioridad: " +
                                filtroUrgencias.getUrgenciasOrdenadas().stream().map(Paciente::getNombre).toList());
                System.out.println("Citas Programadas (Niños Primero): " +
                                filtroCitas.getCitasProgramadasPriorizadas().stream().map(Paciente::getNombre)
                                                .toList());
        }
}