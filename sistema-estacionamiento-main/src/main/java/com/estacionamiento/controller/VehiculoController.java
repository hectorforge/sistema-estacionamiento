package com.estacionamiento.controller;

import com.estacionamiento.entity.Vehiculo;
import com.estacionamiento.usecase.VehiculoUseCase;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Double> registrarSalida(@PathVariable int id) {
        double montoPagar = vehiculoUseCase.registrarSalida(id);

        Map<String, Double> respuesta = new HashMap();
        respuesta.put("montoPagar", montoPagar);

        return respuesta;
    }
}
