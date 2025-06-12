package com.estacionamiento.controller;

import com.estacionamiento.entity.Vehiculo;
import com.estacionamiento.usecase.VehiculoUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoUseCase vehiculoUseCase;

    @PostMapping("/ingreso")
    public Vehiculo registrarIngreso(@RequestBody Vehiculo vehiculo) {
        return vehiculoUseCase.registrarIngreso(vehiculo);
    }
    
    @GetMapping("/listar")
    public List<Vehiculo> listar(){
    	return vehiculoUseCase.findAll();
    }

    @PostMapping("/salida/{id}")
    public double registrarSalida(@PathVariable int id) {
        return vehiculoUseCase.registrarSalida(id);
    }
}
