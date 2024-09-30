package com.triaje.pacientes.data.entities;

import java.util.List;

public interface Filtro<T> {
    List<T> procesar(List<T> pacientes);
}
