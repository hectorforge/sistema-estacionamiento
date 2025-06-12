package com.estacionamiento.controller;

import com.estacionamiento.entity.Estacionamiento;
import com.estacionamiento.usecase.EstacionamientoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estacionamiento")
@RequiredArgsConstructor
public class EstacionamientoController {

    private final EstacionamientoUseCase estacionamientoUseCase;

    @GetMapping("/estado")
    public Estacionamiento consultarEstado() {
        return estacionamientoUseCase.consultarEstadoActual();
    }

    @PostMapping("/asignar")
    public void asignarEspacio() {
        estacionamientoUseCase.asignarEspacio();
    }

    @PostMapping("/liberar")
    public void liberarEspacio() {
        estacionamientoUseCase.liberarEspacio();
    }
}
