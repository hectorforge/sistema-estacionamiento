package com.estacionamiento.usecase;

import java.util.List;

import com.estacionamiento.entity.Vehiculo;

public interface VehiculoUseCase {
    Vehiculo registrarIngreso(Vehiculo vehiculo);
    double registrarSalida(int idVehiculo);
    List<Vehiculo> findAll();
}