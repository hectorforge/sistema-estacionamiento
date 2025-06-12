package com.estacionamiento.model;

import com.estacionamiento.entity.Registro;
import com.estacionamiento.entity.Vehiculo;
import com.estacionamiento.persistence.RegistroRepository;
import com.estacionamiento.persistence.VehiculoRepository;
import com.estacionamiento.usecase.EstacionamientoUseCase;
import com.estacionamiento.usecase.VehiculoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VehiculoModel implements VehiculoUseCase {

    private final VehiculoRepository vehiculoRepo;
    private final RegistroRepository registroRepo;
    private final EstacionamientoUseCase estacionamientoUseCase;

    @Override
    public Vehiculo registrarIngreso(Vehiculo vehiculo) {
        Vehiculo vehiculoRegistrado = vehiculoRepo.save(vehiculo);

        estacionamientoUseCase.asignarEspacio();

        Registro registro = Registro.builder()
                .vehiculo(vehiculoRegistrado)
                .horaEntrada(LocalDateTime.now())
                .build();

        registroRepo.save(registro);
        return vehiculoRegistrado;
    }

    @Override
    public double registrarSalida(int idVehiculo) {
        Vehiculo vehiculo = vehiculoRepo.findById(idVehiculo)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        Registro registro = registroRepo.findByVehiculoAndHoraSalidaIsNull(vehiculo)
                .orElseThrow(() -> new RuntimeException("El vehículo no tiene una entrada activa"));

        LocalDateTime salida = LocalDateTime.now();
        registro.setHoraSalida(salida);

        long minutos = Duration.between(registro.getHoraEntrada(), salida).toMinutes();
        double monto = Math.ceil(minutos / 60.0) * 2.0;

        registro.setMonto(monto);
        registroRepo.save(registro);

        estacionamientoUseCase.liberarEspacio();

        return monto;
    }
}