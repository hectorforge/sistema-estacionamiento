package com.estacionamiento.usecase;

import com.estacionamiento.entity.Estacionamiento;

public interface EstacionamientoUseCase {
    Estacionamiento consultarEstadoActual();
    void asignarEspacio();
    void liberarEspacio();
    Estacionamiento obtenerEstacionamientoActivo();
}