package com.estacionamiento.util;

import com.estacionamiento.entity.Estacionamiento;
import com.estacionamiento.entity.Registro;
import com.estacionamiento.entity.Vehiculo;
import com.estacionamiento.persistence.EstacionamientoRepository;
import com.estacionamiento.persistence.RegistroRepository;
import com.estacionamiento.persistence.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInit implements CommandLineRunner {

    private final VehiculoRepository vehiculoRepo;
    private final EstacionamientoRepository estacionamientoRepo;
    private final RegistroRepository registroRepo;

    @Override
    public void run(String... args) throws Exception {

        for (int i = 1; i <= 8; i++) {
            estacionamientoRepo.save(Estacionamiento.builder()
                    .espaciosDisponibles(20 - i)
                    .espaciosOcupados(i)
                    .activo(i == 1)
                    .build());
        }

        Vehiculo[] vehiculos = new Vehiculo[8];
        for (int i = 1; i <= 8; i++) {
            vehiculos[i - 1] = vehiculoRepo.save(Vehiculo.builder()
                    .placa("XYZ-00" + i)
                    .tipo(i % 2 == 0 ? "Auto" : "Moto")
                    .build());
        }

        for (int i = 0; i < 8; i++) {
            boolean salio = i % 2 == 0;
            LocalDateTime entrada = LocalDateTime.now().minusHours(i + 1);
            LocalDateTime salida = salio ? entrada.plusMinutes(45 + i * 10) : null;
            double monto = salio ? Math.ceil((double) (i + 1) / 1) * 2.0 : 0.0;

            registroRepo.save(Registro.builder()
                    .vehiculo(vehiculos[i])
                    .horaEntrada(entrada)
                    .horaSalida(salida)
                    .monto(monto)
                    .build());
        }
    }
}
