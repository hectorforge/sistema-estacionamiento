package com.estacionamiento.usecase;

import com.estacionamiento.entity.Vehiculo;

public interface VehiculoUseCase {
    Vehiculo registrarIngreso(Vehiculo vehiculo);
    double registrarSalida(int idVehiculo);
}