package com.estacionamiento.model;

import com.estacionamiento.entity.Estacionamiento;
import com.estacionamiento.persistence.EstacionamientoRepository;
import com.estacionamiento.usecase.EstacionamientoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstacionamientoModel implements EstacionamientoUseCase {

    private final EstacionamientoRepository repo;

    @Override
    public Estacionamiento consultarEstadoActual() {
        return repo.findByActivoTrue().stream().findFirst()
                .orElseThrow(() -> new RuntimeException("No hay estacionamiento activo"));
    }

    @Override
    public void asignarEspacio() {
        Estacionamiento est = consultarEstadoActual();
        if (est.getEspaciosDisponibles() <= 0) {
            throw new RuntimeException("No hay espacios disponibles");
        }
        est.setEspaciosDisponibles(est.getEspaciosDisponibles() - 1);
        est.setEspaciosOcupados(est.getEspaciosOcupados() + 1);
        repo.save(est);
    }

    @Override
    public void liberarEspacio() {
        Estacionamiento est = consultarEstadoActual();
        est.setEspaciosDisponibles(est.getEspaciosDisponibles() + 1);
        est.setEspaciosOcupados(est.getEspaciosOcupados() - 1);
        repo.save(est);
    }

    @Override
    public Estacionamiento obtenerEstacionamientoActivo() {
        return consultarEstadoActual();
    }
}